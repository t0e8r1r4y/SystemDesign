package study.book.systemdesign.vectorclock;

import net.jcip.annotations.Immutable;

@Immutable
public class LongVersion {

  private static final LongVersion FIRST = new LongVersion(0);
  private static final LongVersion NOT_VERSIONED = new LongVersion(-1);

  public static LongVersion first() {
    return LongVersion.FIRST;
  }

  public static LongVersion notVersioned() {
    return LongVersion.NOT_VERSIONED;
  }

  public static LongVersion of(final long value) throws IllegalArgumentException {
    Preconditions.checkArgument(value > 0);
    return new LongVersion(value);
  }

  private final long version;

  private LongVersion(final long version) {
    this.version = version;
  }

  @Override
  public boolean equals(final Object object) {
    if (this == object) {
      return true;
    }

    if (object == null || getClass() != object.getClass()) {
      return false;
    }

    return version == ((LongVersion) object).version;
  }

  @Override
  public int hashCode() {
    return (int) (version ^ version >>> 32);
  }

  public LongVersion max(final LongVersion other) {
    return version < other.version ? other : this;
  }

  public LongVersion next() {
    return LongVersion.of(version + 1);
  }

  public LongVersion next(final LongVersion other) throws NullPointerException {
    Preconditions.checkNotNull(other);
    return LongVersion.of(Math.max(version, other.version) + 1);
  }

  public boolean isBiggerThan(LongVersion other){
    return this.version >= other.version;
  }

  @Override
  public String toString() {
    return String.valueOf(version);
  }
}
