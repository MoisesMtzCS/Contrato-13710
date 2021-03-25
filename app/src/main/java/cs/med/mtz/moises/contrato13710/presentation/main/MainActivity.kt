package cs.med.mtz.moises.contrato13710.presentation.main

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.renderscript.ScriptGroup
import cs.med.mtz.moises.contrato13710.R
import cs.med.mtz.moises.contrato13710.databinding.ActivityMainBinding
import cs.med.mtz.moises.contrato13710.presentation.new_goal.NewGoalActivity

/** */
class MainActivity : AppCompatActivity() {
    /** */

    private val binding: ActivityMainBinding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }

    /** */
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        goToCreateContract()
    }

    /** */

    private fun goToCreateContract() {
        val intent = Intent(this, NewGoalActivity::class.java)
        binding.start.setOnClickListener {
            startActivity(intent)
        }
    }

}