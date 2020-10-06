package csvFilter

class CsvFilter {
    fun filter(lines: List<String>) : List<String> {
        val result = mutableListOf<String>()
        result.add(lines[0])
        val invoice = lines[1]
        val fields = invoice.split(',')
        val ivaFieldIndex = 4
        val igicFieldIndex = 5
        val ivaField = fields[ivaFieldIndex]
        val igicField = fields[igicFieldIndex]
        val decimalRegex = "\\d+(\\.\\d+)?".toRegex()
        val bothTaxFieldsAreAdded = (ivaField.matches(decimalRegex) || igicField.matches(decimalRegex))
        val bothTaxFieldsAreEmpty = !(ivaField.matches(decimalRegex) && igicField.matches(decimalRegex))
        if (bothTaxFieldsAreAdded && bothTaxFieldsAreEmpty){
            result.add(lines[1])
        }
        return result.toList()
    }
}