package cs.med.mtz.moises.contrato13710.domain

import cs.med.mtz.moises.contrato13710.domain.entity.Contract
import cs.med.mtz.moises.contrato13710.data.contract.dao.ContractDao
import cs.med.mtz.moises.contrato13710.data.contract.dto.ContractDto

/** */
class ContractRepository(
    private val contractDao: ContractDao
){

    /** */
    suspend fun createContract(target: String) {
        val contractDto = ContractDto(1, target)
        contractDao.insert(contractDto)
    }

    suspend fun getContracts(): List<Contract> {
        val contractsDto: List<ContractDto> = contractDao.getAll()
        val contracts: List<Contract> = contractsDto.map { Contract(it.id!!, it.target) }
        return contracts
    }

}