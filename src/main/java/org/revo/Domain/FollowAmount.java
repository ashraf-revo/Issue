package org.revo.Domain;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by ashraf on 26/12/16.
 */
public class FollowAmount extends Amount {
    private Set<Entry<Size, Integer>> amount = new HashSet<>();

    public Set<Entry<Size, Integer>> getAmount() {
        return amount;
    }

    public FollowAmount setAmount(Set<Entry<Size, Integer>> amount) {
        this.amount = amount;
        return this;
    }

    static public class Entry<S, I> {
        private S key;
        private I value;

        public Entry() {
        }

        public Entry(S key, I value) {
            this.key = key;
            this.value = value;
        }

        public S getKey() {
            return key;
        }

        public Entry setKey(S key) {
            this.key = key;
            return this;
        }

        public I getValue() {
            return value;
        }

        public Entry setValue(I value) {
            this.value = value;
            return this;
        }
    }
}
