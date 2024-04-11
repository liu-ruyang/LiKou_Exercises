package org.example;

public class RangeModule {

    int left;
    int right;
    RangeModule next;

    public RangeModule() {
        left = right = 0;
        next = null;
    }

    public void addRange(int left, int right) {
        if (this.left == 0 && this.right == 0) {
            this.left = left;
            this.right = right;
            return;
        }

        if (right < this.left) {
            RangeModule rm = new RangeModule();
            rm.left = this.left;
            rm.right = this.right;
            rm.next = this.next;
            this.left = left;
            this.right = right;
            this.next = rm;
        } else if (right == this.left) {
            this.left = left;
        } else {
            RangeModule rmBefore = null;
            RangeModule rm = this;
            // RangeModule rmNext = this.next;
            while (rm != null && rm.right <= left) {
                rmBefore = rm;
                rm = rm.next;
                // rmNext = rm.next;
            }

            RangeModule rm2 = rm;
            RangeModule rm2Before = rmBefore;
            while (rm2 != null && rm2.left <= right) {
                rm2Before = rm2;
                rm2 = rm2.next;
            }

            if (rm == null) {
                if (rmBefore.right == left) {
                    rmBefore.right = right;
                    return;
                } else {
                    rm = new RangeModule();
                    rm.left = left;
                    rm.right = right;
                    rm.next = null;
                    rmBefore.next = rm;
                    return;
                }
            } else {
                if (rm.left >= left) {
                    rm.left = left;
                    if (rm2Before.right > right) {
                        rm.right = rm2Before.right;
                        rm.next = rm2Before.next;
                    } else {
                        rm.right = right;
                        rm.next = rm2Before;
                    }
                } else {
                    if (rm2Before.right > right) {
                        rm.right = rm2Before.right;
                        rm.next = rm2Before.next;
                    } else {
                        rm.right = right;
                        rm.next = rm2Before;
                    }
                }
            }
        }
    }

    public boolean queryRange(int left, int right) {
        // RangeModule rmBefore = null;
        RangeModule rm = this;
        while (rm != null && rm.right <= left) {
            // rmBefore = rm;
            rm = rm.next;
            // rmNext = rm.next;
        }
        if (rm == null || rm.left > left || rm.right < right)
            return false;
        return true;
    }

    public void removeRange(int left, int right) {
        RangeModule rmBefore = null;
        RangeModule rm = this;
        // RangeModule rmNext = this.next;
        while (rm != null && rm.right <= left) {
            rmBefore = rm;
            rm = rm.next;
            // rmNext = rm.next;
        }

        RangeModule rm2 = rm;
        RangeModule rm2Before = rmBefore;
        while (rm2 != null && rm2.left <= right) {
            rm2Before = rm2;
            rm2 = rm2.next;
        }

        if (rm != null) {
            if (rm.left > left) {
                if (rm2Before.right < right) {
                    rmBefore.next = rm2Before.next;
                } else {
                    RangeModule newRM = new RangeModule();
                    newRM.next = rm2Before.next;
                    newRM.right = rm2Before.right;
                    newRM.left = right;
                    rmBefore.next = newRM;
                    // rm.next = newRM;
                    // rm.right = left;
                }
            } else {
                if (rm2Before.right < right) {
                    rm.right = left;
                    rm.next = rm2Before.next;
                } else {
                    RangeModule newRM = new RangeModule();
                    newRM.next = rm2Before.next;
                    newRM.left = right;
                    newRM.right = rm2Before.right;
                    rm.right = left;
                    rm.next = newRM;
                }
            }
        }
    }

    public static void main(String[] args) {
        RangeModule rangeModule = new RangeModule();
        rangeModule.addRange(10, 20);
        rangeModule.removeRange(14, 16);

        // rangeModule.queryRange(10,14);
    }

    public static void myPrint(RangeModule rangeModule) {
        // if (rangeModule.)
    }
}

/**
 * Your RangeModule object will be instantiated and called as such:
 * RangeModule obj = new RangeModule();
 * obj.addRange(left,right);
 * boolean param_2 = obj.queryRange(left,right);
 * obj.removeRange(left,right);
 */