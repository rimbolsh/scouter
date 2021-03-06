// Generated by delombok at Sun Feb 26 12:31:38 KST 2017
package scouter.bytebuddy.matcher;

import java.util.Iterator;

/**
 * A matcher that matches a given element of a collection. If no such element is contained by the matched iterable, the matcher
 * returns {@code false}.
 *
 * @param <T> The type of the elements contained by the collection.
 */
public class CollectionElementMatcher<T> extends ElementMatcher.Junction.AbstractBase<Iterable<? extends T>> {
    /**
     * The index of the matched element.
     */
    private final int index;
    /**
     * The matcher for the given element, if it exists.
     */
    private final ElementMatcher<? super T> matcher;

    /**
     * Creates a new matcher for an element in a collection.
     *
     * @param index          The index of the matched element.
     * @param matcher The matcher for the given element, if it exists.
     */
    public CollectionElementMatcher(int index, ElementMatcher<? super T> matcher) {
        this.index = index;
        this.matcher = matcher;
    }

    @Override
    public boolean matches(Iterable<? extends T> target) {
        Iterator<? extends T> iterator = target.iterator();
        for (int index = 0; index < this.index; index++) {
            if (iterator.hasNext()) {
                iterator.next();
            } else {
                return false;
            }
        }
        return iterator.hasNext() && matcher.matches(iterator.next());
    }

    @Override
    public String toString() {
        return "with(" + index + " matches " + matcher + ")";
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("all")
    @javax.annotation.Generated("lombok")
    public boolean equals(final java.lang.Object o) {
        if (o == this) return true;
        if (!(o instanceof CollectionElementMatcher)) return false;
        final CollectionElementMatcher<?> other = (CollectionElementMatcher<?>) o;
        if (!other.canEqual((java.lang.Object) this)) return false;
        if (this.index != other.index) return false;
        final java.lang.Object this$matcher = this.matcher;
        final java.lang.Object other$matcher = other.matcher;
        if (this$matcher == null ? other$matcher != null : !this$matcher.equals(other$matcher)) return false;
        return true;
    }

    @java.lang.SuppressWarnings("all")
    @javax.annotation.Generated("lombok")
    protected boolean canEqual(final java.lang.Object other) {
        return other instanceof CollectionElementMatcher;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("all")
    @javax.annotation.Generated("lombok")
    public int hashCode() {
        final int PRIME = 59;
        int result = 1;
        result = result * PRIME + this.index;
        final java.lang.Object $matcher = this.matcher;
        result = result * PRIME + ($matcher == null ? 43 : $matcher.hashCode());
        return result;
    }
}
