package dk.itu.moapd.viewpage

import android.graphics.Color
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.fragment_main.*
import java.util.*

class MainFragment : Fragment() {

    private var mColor: Int? = 0

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_main, container, false)

        mColor = if (savedInstanceState == null) {
            val random = Random()
            Color.argb(255, random.nextInt(256),
                random.nextInt(256),
                random.nextInt(256))
        } else
            savedInstanceState.getInt("COLOR")

        return view
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        scroll_view.setBackgroundColor(mColor!!)
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putInt("COLOR", mColor!!)
    }

}
