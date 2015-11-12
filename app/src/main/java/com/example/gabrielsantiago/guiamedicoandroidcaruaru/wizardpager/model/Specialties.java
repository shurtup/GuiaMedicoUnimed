package com.example.gabrielsantiago.guiamedicoandroidcaruaru.wizardpager.model;

/**
 * Created by gabriel.santiago on 12/11/2015.
 */
import com.example.gabrielsantiago.guiamedicoandroidcaruaru.wizardpager.ui.SingleChoiceFragment;

import android.support.v4.app.Fragment;
import android.text.TextUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * A page representing a branching point in the wizard. Depending on which choice is selected, the
 * next set of steps in the wizard may change.
 */
public class Specialties extends SingleFixedChoicePage {
    private List<Branch> mBranches = new ArrayList<Branch>();

    public Specialties(ModelCallbacks callbacks, String title) {
        super(callbacks, title);
    }

    @Override
    public Page findByKey(String key) {
        if (getKey().equals(key)) {
            return this;
        }

        for (Branch branch : mBranches) {
            Page found = branch.childPageList.findByKey(key);
            if (found != null) {
                return found;
            }
        }

        return null;
    }

    @Override
    public void flattenCurrentPageSequence(ArrayList<Page> destination) {
        super.flattenCurrentPageSequence(destination);
        for (Branch branch : mBranches) {
            if (branch.choice.equals(mData.getString(Page.SIMPLE_DATA_KEY))) {
                branch.childPageList.flattenCurrentPageSequence(destination);
                break;
            }
        }
    }

    public Specialties addBranch(String choice, Page... childPages) {
        PageList childPageList = new PageList(childPages);
        for (Page page : childPageList) {
            page.setParentKey(choice);
        }
        mBranches.add(new Branch(choice, childPageList));
        return this;
    }

    public Specialties addBranch(String choice) {
        mBranches.add(new Branch(choice, new PageList()));
        return this;
    }

    @Override
    public Fragment createFragment() {
        return SingleChoiceFragment.create(getKey());
    }

    public String getOptionAt(int position) {
        return mBranches.get(position).choice;
    }

    public int getOptionCount() {
        return mBranches.size();
    }

    @Override
    public void getReviewItems(ArrayList<ReviewItem> dest) {
        dest.add(new ReviewItem(getTitle(), mData.getString(SIMPLE_DATA_KEY), getKey()));
    }

    @Override
    public boolean isCompleted() {
        return !TextUtils.isEmpty(mData.getString(SIMPLE_DATA_KEY));
    }

    @Override
    public void notifyDataChanged() {
        mCallbacks.onPageTreeChanged();
        super.notifyDataChanged();
    }

    public Specialties setValue(String value) {
        mData.putString(SIMPLE_DATA_KEY, value);
        return this;
    }

    private static class Branch {
        public String choice;
        public PageList childPageList;

        private Branch(String choice, PageList childPageList) {
            this.choice = choice;
            this.childPageList = childPageList;
        }
    }
}
