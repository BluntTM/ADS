import java.util.*;
/* implementation only using enhanced forloops */
class Solution2alt {
  @SuppressWarnings("unchecked")
  public static Queue<Integer>[] fillBuckets(int[] K) {
    if (K.length == 0)
      return new Queue[]{};
    int kmin, kmax = kmin = K[0];
    for (int k : K) {
        if (k > kmax)
            kmax = k;
        if (k < kmin)
            kmin = k;
    }
    Queue<Integer>[] B = new Queue[kmax - kmin + 1];
    int i = 0;
    for (Queue<Integer> b : B) {
      b = B[i++] = new LinkedList<>();
      for (int k : K)
        if (k == kmin + i-1)
          b.add(k);
          // b.offer(k);
          /* The offer method inserts an element if possible, otherwise returning false.
             This differs from the Collection.add method, which can fail to add an element
             only by throwing an unchecked exception. The offer method is designed for use
             when failure is a normal, rather than exceptional occurrence, for example, in
             fixed-capacity (or "bounded") queues. */
    }
    return B;
  }

  public static int[] readBuckets(Queue<Integer>[] B) {
    int is, iu = is = 0;
    List<Integer> S = new LinkedList<Integer>();
    for (Queue<Integer> b : B)
      for (iu = 0; iu < b.size(); iu++)
        S.add(b.remove());
    int[] AS = new int[S.size()];
    for (int s : S)
        AS[is++] = s;
    return AS;
  }
}
