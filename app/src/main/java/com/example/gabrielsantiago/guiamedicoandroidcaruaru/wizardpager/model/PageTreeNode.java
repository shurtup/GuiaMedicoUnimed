package com.example.gabrielsantiago.guiamedicoandroidcaruaru.wizardpager.model;

import java.util.ArrayList;

/**
 * Created by gabriel.santiago on 12/11/2015.
 */
public interface PageTreeNode {
    public Page findByKey(String key);
    public void flattenCurrentPageSequence(ArrayList<Page> dest);
}
