package cs.med.mtz.moises.contrato13710.presentation.contract_details

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import cs.med.mtz.moises.contrato13710.R
import cs.med.mtz.moises.contrato13710.databinding.ActivityContractDetailsBinding

class ContractDetailsActivity : AppCompatActivity() {
    /** */

    val binding: ActivityContractDetailsBinding by lazy {
        ActivityContractDetailsBinding.inflate(layoutInflater)
    }

    /** */

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        execute()
    }

    fun execute() {
        val durationInDays = intent.extras?.getInt("DURATION")!!
        val detailsOfTarget = intent.extras?.getString("TARGET")!!
        binding.tvTarget.text =
            getString(R.string.contract_details_of_target, detailsOfTarget)
        // binding.tvTarget.text = intent.extras?.getString("TARGET")
        binding.tvTime.text =
            getString(R.string.contract_duration_in_days, durationInDays)
//        binding.tvTime.text = resources
//            .getQuantityString(R.plurals.days_count, durationInDays, durationInDays)


    }
}