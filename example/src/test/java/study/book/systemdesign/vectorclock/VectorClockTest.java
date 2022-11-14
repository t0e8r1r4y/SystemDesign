package study.book.systemdesign.vectorclock;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

/**
 * https://github.com/albertattard/vector-clock
 * https://en.wikipedia.org/wiki/Vector_clock
 */
class VectorClockTest {

  StringNode serverA = StringNode.of("a");
  StringNode serverB = StringNode.of("b");
  StringNode serverC = StringNode.of("c");
  VectorClock initClockOfA = VectorClock.first(serverA);
  VectorClock initClockOfB = VectorClock.first(serverB);
  VectorClock initClockOfC = VectorClock.first(serverC);

  @Test
  @DisplayName("최초 데이터를 serverA에 쓴 경우 버전 증가")
  void test(){
    VectorClock nextMetaData = initClockOfA.next();
    assertEquals(nextMetaData.version(), LongVersion.of(1));
  }

  @Test
  @DisplayName("ServerB에서 두번째 데이터 업데이트 한 경우")
  void test4(){
    VectorClock nextMetaData = initClockOfB.add(initClockOfA.next());
    assertEquals(nextMetaData.version(serverA).orElseThrow(), LongVersion.of(1));
    assertEquals(nextMetaData.version(serverB).orElseThrow(), LongVersion.of(1));

  }

  @Test
  @DisplayName("ServerB, ServerC에서 각각 데이터 업데이트 한 경우 충돌이 발생한다.")
  void test5(){
    VectorClock nextMetaData1 = initClockOfB.add(initClockOfA.next());
    VectorClock nextMetaData2 = initClockOfC.add(initClockOfA.next());
    Assertions.assertThat(VectorClock.isConflict(nextMetaData1,nextMetaData2)).isTrue();
  }

  @Test
  @DisplayName("ServerA에서 충돌을 해소한 경우")
  void test6(){
    VectorClock currentClockOfA = initClockOfA.next();
    VectorClock nextMetaData1 = initClockOfB.add(currentClockOfA);
    VectorClock nextMetaData2 = initClockOfC.add(currentClockOfA);
    Assertions.assertThat(VectorClock.isConflict(nextMetaData1,nextMetaData2)).isTrue();

    VectorClock merged = currentClockOfA.resolve(List.of(nextMetaData1,nextMetaData2));
    Assertions.assertThat(VectorClock.isConflict(merged,currentClockOfA)).isFalse();
    Assertions.assertThat(VectorClock.isConflict(merged,nextMetaData1)).isFalse();
    Assertions.assertThat(VectorClock.isConflict(merged,nextMetaData2)).isFalse();
  }

  @Test
  public void multipleClocks() {
    /* Based on the image shown in Wiki: https://en.wikipedia.org/wiki/Vector_clock#/media/File:Vector_Clock.svg */
    VectorClock a = VectorClock.first("a");
    VectorClock b = VectorClock.first("b");
    VectorClock c = VectorClock.first("c");

    assertEquals("[a:0]", a.toString());
    assertEquals("[b:0]", b.toString());
    assertEquals("[c:0]", c.toString());

    /* C cause B */
    c = c.next();
    b = b.add(c);

    assertEquals("[a:0]", a.toString());
    assertEquals("[b:1,c:1]", b.toString());
    assertEquals("[c:1]", c.toString());

    /* B cause A */
    b = b.next();
    a = a.add(b);

    assertEquals("[a:1,b:2,c:1]", a.toString());
    assertEquals("[b:2,c:1]", b.toString());
    assertEquals("[c:1]", c.toString());

    /* B cause C */
    b = b.next();
    c = c.add(b);

    assertEquals("[a:1,b:2,c:1]", a.toString());
    assertEquals("[b:3,c:1]", b.toString());
    assertEquals("[b:3,c:2]", c.toString());

    /* A cause B */
    a = a.next();
    b = b.add(a);

    assertEquals("[a:2,b:2,c:1]", a.toString());
    assertEquals("[a:2,b:4,c:1]", b.toString());
    assertEquals("[b:3,c:2]", c.toString());

    /* C cause A */
    c = c.next();
    a = a.add(c);

    assertEquals("[a:3,b:3,c:3]", a.toString());
    assertEquals("[a:2,b:4,c:1]", b.toString());
    assertEquals("[b:3,c:3]", c.toString());

    /* B cause C */
    b = b.next();
    c = c.add(b);

    assertEquals("[a:3,b:3,c:3]", a.toString());
    assertEquals("[a:2,b:5,c:1]", b.toString());
    assertEquals("[a:2,b:5,c:4]", c.toString());

    /* C cause A */
    c = c.next();
    a = a.add(c);

    assertEquals("[a:4,b:5,c:5]", a.toString());
    assertEquals("[a:2,b:5,c:1]", b.toString());
    assertEquals("[a:2,b:5,c:5]", c.toString());
  }

  @Test
  public void oneClock() {
    final StringNode a = StringNode.of("a");
    final StringNode b = StringNode.of("b");
    final StringNode c = StringNode.of("c");

    VectorClock clock = VectorClock.first(a);
    assertEquals(1, clock.size());
    assertEquals(LongVersion.first(), clock.version());

    clock = clock.add(b, LongVersion.first());
    assertEquals(2, clock.size());
    assertEquals(LongVersion.of(1), clock.version());
    assertEquals(LongVersion.first(), clock.version(b).get());

    clock = clock.add(c, LongVersion.first());
    assertEquals(3, clock.size());
    assertEquals(LongVersion.of(2), clock.version());
    assertEquals(LongVersion.first(), clock.version(b).get());
    assertEquals(LongVersion.first(), clock.version(c).get());
  }
}
