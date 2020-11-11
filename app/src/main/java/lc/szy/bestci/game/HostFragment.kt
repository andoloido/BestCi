package lc.szy.bestci.game

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.commit
import kotlinx.android.synthetic.main.fragment_host.*
import lc.szy.bestci.R

class HostFragment : Fragment(R.layout.fragment_host) {
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        firstGameBt.setOnClickListener {
            replaceFragment(FirstGameFragment())
        }
    }

    fun replaceFragment(t: Fragment) {
        parentFragmentManager.commit {
            replace(R.id.container, t)
            addToBackStack(null)
        }
    }
}