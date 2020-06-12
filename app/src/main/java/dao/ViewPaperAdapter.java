package dao;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import java.util.ArrayList;
import java.util.List;

public class ViewPaperAdapter extends FragmentPagerAdapter {

    private final List<Fragment> listFrag = new ArrayList<>();
    private final List<String> listTitle = new ArrayList<>();

    public ViewPaperAdapter(@NonNull FragmentManager fm, int behavior) {
        super(fm, behavior);
    }

    public ViewPaperAdapter(FragmentManager supportFragmentManager) {
        super(supportFragmentManager);
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        return listFrag.get(position);
    }

    @Override
    public int getCount() {
        return listTitle.size();
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return listTitle.get(position);
    }

    public void  addFragment(Fragment fragment, String title){
        listFrag.add(fragment);
        listTitle.add(title);
    }
}
