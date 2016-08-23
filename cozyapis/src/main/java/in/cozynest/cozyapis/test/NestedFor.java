package in.cozynest.cozyapis.test;

public class NestedFor {

    public static interface IAction {
        public void act(int[] indices);
    }

    private final int lo;
    private final int hi;
    private final IAction action;

    public NestedFor(int lo, int hi, IAction action) {
        this.lo = lo;
        this.hi = hi;
        this.action = action;
    }

    public void nFor (int depth) {
        n_for (0, new int[0], depth);
    }

    private void n_for (int level, int[] indices, int maxLevel) {
        if (level == maxLevel) {
            action.act(indices);
        } else {
            int newLevel = level + 1;
            int[] newIndices = new int[newLevel];
            System.arraycopy(indices, 0, newIndices, 0, level);
            newIndices[level] = lo;
            while (newIndices[level] < hi) {
                n_for(newLevel, newIndices, maxLevel);
                ++newIndices[level];
            }
        }
    }
    
    public static void main(String[] args) {
        for (int i = 0; i <=5; ++i) {
            final int depth = i;
            System.out.println("Depth " + depth);
            IAction testAction = new IAction() {
                public void act(int[] indices) {
                    System.out.print("Hello from level " + depth + ":");
                    for (int i : indices) { System.out.print(" " + i); }
                    System.out.println();
                }
            };
            NestedFor nf = new NestedFor(0, 3, testAction);
            nf.nFor(depth);
        }
    }
}

