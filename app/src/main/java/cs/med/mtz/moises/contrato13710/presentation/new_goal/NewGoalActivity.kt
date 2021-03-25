package cs.med.mtz.moises.contrato13710.presentation.new_goal

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModel
import cs.med.mtz.moises.contrato13710.R
import cs.med.mtz.moises.contrato13710.databinding.ActivityNewGoalBinding
import org.koin.android.viewmodel.ext.android.viewModel

class NewGoalActivity : AppCompatActivity() {

    private val nameGoal: String
        get() = binding.nameGoal.toString()

    private val target: String
        get() = binding.target.toString()

    private val newGoalViewModel: NewGoalViewModel by viewModel()

    /** */

    private val binding: ActivityNewGoalBinding by lazy {
        ActivityNewGoalBinding.inflate(layoutInflater)
    }

    /** */
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        //execute()
    }

    private fun execute() {
        binding.save.setOnClickListener {
            newGoalViewModel.newGoal(nameGoal)
        }
    }

}

