package ss12_java_collection_framework.practice.thuc_hanh_cay_tim_kiem_nhi_phan;

public interface Tree <E>{
    /**
     * Insert element e into the binary search tree.
     * Return tree if the element is inserted successfully
     */
    public boolean insert (E e);
    /**
     * Inorder traversal from the root
     */
    public void inorder();
        /**
         * Get the number of nodes in the tree
         */
    public int getSize();
}
