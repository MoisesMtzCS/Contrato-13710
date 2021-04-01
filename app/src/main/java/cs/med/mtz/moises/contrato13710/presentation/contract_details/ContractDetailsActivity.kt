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

    fun execute (){
        binding.tvDetails.text = intent.extras?.getString("TARGET")
    }
}