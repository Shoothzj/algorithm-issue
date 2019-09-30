package com.github.shoothzj.algorithm.leetcode;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Q0938 {

    private static final Logger logger = LoggerFactory.getLogger(Q0938.class);

    public int rangeSumBST(TreeNode root, int L, int R) {
        if (root == null) {
            return 0;
        }

        if (root.val < L) {
            return rangeSumBST(root.right, L, R);
        } else if (root.val == L) {
            return rangeSumBST(root.right, L, R) + root.val;
        } else if (root.val < R) {
            return root.val + rangeSumBST(root.left, L, R) + rangeSumBST(root.right, L, R);
        } else if (root.val == R) {
            return root.val + rangeSumBST(root.left, L, R);
        } else {
            //root.val > R
            return rangeSumBST(root.left, L, R);
        }
    }

}
