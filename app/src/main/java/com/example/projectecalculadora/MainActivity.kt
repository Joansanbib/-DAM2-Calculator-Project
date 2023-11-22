package com.example.projectecalculadora

import android.graphics.Color
import android.os.Bundle
import android.os.PersistableBundle
import android.view.Gravity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.widget.ConstraintSet.Layout
import com.google.android.material.snackbar.Snackbar
import org.w3c.dom.Text
import java.lang.Exception


class MainActivity : AppCompatActivity() {
    var cadena_print: StringBuilder = StringBuilder()
    var lastChar: Int = -1
    var setComa: Boolean = false
    var wrongComa: Boolean = false
    var countDecimals: Int = 0
    var esDecimal: Boolean = false
    var limitDecimals: Boolean = false
    var materialSeleccionat: Boolean = false
    var inputMaterialDouble: Double = 0.0
    var cotitzacioMaterial : DoubleArray = DoubleArray(4)
    var preuMaterial : DoubleArray = DoubleArray(4)
    var contBtn : Int = 0
    var printRes2String : String = ""






    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val resultTemp: TextView = findViewById(R.id.resultTemporal)
        val resultTemp2: TextView = findViewById(R.id.resultTemporal2)
        val btnMaterials  = arrayOf(findViewById<Button>(R.id.OrBtn),
            findViewById<Button>(R.id.PlataBtn), findViewById<Button>(R.id.PlatinoBtn), findViewById<Button>(R.id.CoureBtn))
        val nomMaterials : Array<String> = arrayOf(getString(R.string.or), getString(R.string.plata), getString(R.string.platino), getString(R.string.coure))

        findViewById<Button>(R.id.btn0).setOnClickListener {
            if (cadena_print.isNotEmpty() && materialSeleccionat) {
                cadena_print.append(getString(R.string.num0))
                lastChar++
                logicaComa(resultTemp, resultTemp2)
            } else {
                resultTemp.setText(getString(R.string.num0))
            }

        }
        findViewById<Button>(R.id.btn1).setOnClickListener {
            if (materialSeleccionat) {
                cadena_print.append(getString(R.string.num1))
                lastChar++
                logicaDecimal()
                logicaComa(resultTemp, resultTemp2)
            }
            else{
                Toast.makeText(this, getString(R.string.errSelectMat), Toast.LENGTH_SHORT).show()
            }
        }
        findViewById<Button>(R.id.btn2).setOnClickListener {
            if(materialSeleccionat) {
                cadena_print.append(getString(R.string.num2))
                lastChar++
                logicaDecimal()
                logicaComa(resultTemp, resultTemp2)
            }
            else{
                Toast.makeText(this, getString(R.string.errSelectMat), Toast.LENGTH_SHORT).show()
            }
        }
        findViewById<Button>(R.id.btn3).setOnClickListener {
            if(materialSeleccionat) {
                cadena_print.append(getString(R.string.num3))
                lastChar++
                logicaDecimal()
                logicaComa(resultTemp, resultTemp2)
            }
            else{
                Toast.makeText(this, getString(R.string.errSelectMat), Toast.LENGTH_SHORT).show()
            }
        }
        findViewById<Button>(R.id.btn4).setOnClickListener {
            if(materialSeleccionat) {
                cadena_print.append(getString(R.string.num4))
                lastChar++
                logicaDecimal()
                logicaComa(resultTemp, resultTemp2)
            }
            else{
                Toast.makeText(this, getString(R.string.errSelectMat), Toast.LENGTH_SHORT).show()
            }
        }
        findViewById<Button>(R.id.btn5).setOnClickListener {
            if(materialSeleccionat) {
                cadena_print.append(getString(R.string.num5))
                lastChar++
                logicaDecimal()
                logicaComa(resultTemp, resultTemp2)
            }
            else{
                Toast.makeText(this, getString(R.string.errSelectMat), Toast.LENGTH_SHORT).show()
            }
        }
        findViewById<Button>(R.id.btn6).setOnClickListener {
            if(materialSeleccionat) {
                cadena_print.append(getString(R.string.num6))
                lastChar++
                logicaDecimal()
                logicaComa(resultTemp, resultTemp2)
            }
            else{
                Toast.makeText(this, getString(R.string.errSelectMat), Toast.LENGTH_SHORT).show()
            }
        }
        findViewById<Button>(R.id.btn7).setOnClickListener {
            if(materialSeleccionat) {
                cadena_print.append(getString(R.string.num7))
                lastChar++
                logicaDecimal()
                logicaComa(resultTemp, resultTemp2)
            }
            else{
                Toast.makeText(this, getString(R.string.errSelectMat), Toast.LENGTH_SHORT).show()
            }
        }
        findViewById<Button>(R.id.btn8).setOnClickListener {
            if(materialSeleccionat) {
                cadena_print.append(getString(R.string.num8))
                lastChar++
                logicaDecimal()
                logicaComa(resultTemp, resultTemp2)
            }
            else{
                Toast.makeText(this, getString(R.string.errSelectMat), Toast.LENGTH_SHORT).show()
            }
        }
        findViewById<Button>(R.id.btn9).setOnClickListener {
            if(materialSeleccionat) {
                cadena_print.append(getString(R.string.num9))
                lastChar++
                logicaDecimal()
                logicaComa(resultTemp, resultTemp2)
            }
            else{
                Toast.makeText(this, getString(R.string.errSelectMat), Toast.LENGTH_SHORT).show()
            }
        }
        findViewById<Button>(R.id.btnComa).setOnClickListener {
            if(materialSeleccionat && cadena_print.isNotEmpty()) {
                cadena_print.append(getString(R.string.coma))
                var conversioStr : String = cadena_print.toString().replace(",", ".")
                resultTemp.setText(conversioStr)
                cadena_print = StringBuilder(conversioStr)
                setComa = true
                lastChar++
                countDecimals = 0
                esDecimal = true
            }
        }
        findViewById<Button>(R.id.btnBorrar).setOnClickListener {
            if(materialSeleccionat) {
                alBorrar(resultTemp, resultTemp2)
            }
            else{
                Toast.makeText(this, getString(R.string.errSelectMat), Toast.LENGTH_SHORT).show()
            }
        }
        findViewById<Button>(R.id.btnCE).setOnClickListener {
            if(materialSeleccionat) {
                cadena_print.setLength(0)
                lastChar = -1
                countDecimals = 0
                esDecimal = false
                resultTemp.setText(getString(R.string.num0))
                resultTemp2.setText(getString(R.string.num0))
            }
            else{
                Toast.makeText(this, getString(R.string.errSelectMat), Toast.LENGTH_SHORT).show()
            }
        }
        findViewById<Button>(R.id.OrBtn).setOnClickListener {
            if (!materialSeleccionat) {
                contBtn = 0
                btnMaterialInput(contBtn, btnMaterials, nomMaterials)
            }
        }
        findViewById<Button>(R.id.PlataBtn).setOnClickListener {
            if (!materialSeleccionat) {
                contBtn = 1
                btnMaterialInput(contBtn, btnMaterials, nomMaterials)
            }
        }
       findViewById<Button>(R.id.PlatinoBtn).setOnClickListener {
           if (!materialSeleccionat) {
               contBtn = 2
               btnMaterialInput(contBtn, btnMaterials, nomMaterials)
           }
        }
        findViewById<Button>(R.id.CoureBtn).setOnClickListener {
            if (!materialSeleccionat) {
                contBtn = 3
                btnMaterialInput(contBtn, btnMaterials, nomMaterials)
            }
        }

    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        var StrSaveCadena = cadena_print.toString()
        outState.putString("cadenaPrint", StrSaveCadena)
        outState.putDouble("cotzOr", cotitzacioMaterial[0])
        outState.putDouble("cotzPlata", cotitzacioMaterial[1])
        outState.putDouble("cotzPlatino", cotitzacioMaterial[2])
        outState.putDouble("cotzCoure", cotitzacioMaterial[3])
        outState.putInt("lastChar",lastChar)
        outState.putBoolean("setComa", setComa)
        outState.putBoolean("wrongComa", wrongComa)
        outState.putInt("countDecimals", countDecimals)
        outState.putBoolean("esDecimal", esDecimal)
        outState.putBoolean("limitDecimals", limitDecimals)
        outState.putBoolean("materialSeleccionat", materialSeleccionat)
        outState.putInt("contBtn", contBtn)





    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
        cadena_print = StringBuilder(savedInstanceState.getString("cadenaPrint"))
        cotitzacioMaterial[0] = savedInstanceState.getDouble("cotzOr")
        cotitzacioMaterial[1] = savedInstanceState.getDouble("cotzPlata")
        cotitzacioMaterial[2] = savedInstanceState.getDouble("cotzPlatino")
        cotitzacioMaterial[3] = savedInstanceState.getDouble("cotzCoure")
        lastChar = savedInstanceState.getInt("lastChar")
        setComa = savedInstanceState.getBoolean("setComa")
        wrongComa = savedInstanceState.getBoolean("wrongComa")
        countDecimals = savedInstanceState.getInt("countDecimals")
        esDecimal = savedInstanceState.getBoolean("esDecimal")
        limitDecimals = savedInstanceState.getBoolean("limitDecimals")
        materialSeleccionat = savedInstanceState.getBoolean("materialSeleccionat")
        contBtn = savedInstanceState.getInt("contBtn")



    }

    fun validacioComa(): Boolean {
        var wrongComa: Boolean = false
        if (setComa) {
            try {
                var deStrBuildaStr: String = cadena_print.toString()
                var conPuntos: String = deStrBuildaStr.replace(",", ".")
                var intAdouble: Double = conPuntos.toDouble()
            } catch (e: NumberFormatException) {
                wrongComa = true
            }
        }
        return wrongComa
    }

    fun printAfterComa(resultTemp: TextView, resultTemp2: TextView) {

        if (wrongComa) {
            resultTemp.setText(getString(R.string.num0))
            resultTemp2.setText(getString(R.string.num0))
            cadena_print.setLength(0)
            esDecimal = false
            countDecimals = 0
            lastChar = -1
            Toast.makeText(this, getString(R.string.wrong_coma), Toast.LENGTH_LONG).show()
        } else {
            resultTemp.setText(cadena_print)
            mostrarResultTemporal2(resultTemp, resultTemp2, printRes2String)
        }

        //Error al tirar enrere quan no hi ha res

    }

    fun logicaComa(resultTemp: TextView, resultTemp2: TextView) {
        if (setComa) {
            wrongComa = validacioComa()
            printAfterComa(resultTemp, resultTemp2)
        } else {
            resultTemp.setText(cadena_print)
            mostrarResultTemporal2(resultTemp, resultTemp2, printRes2String)




        }
        setComa = false
    }

    fun logicaDecimal() {
        //Al reiniciar num (0) countDecimals = 0
        if (esDecimal) {
            countDecimals++
        }
        if (countDecimals > 6) {
            cadena_print.deleteCharAt(lastChar)
            countDecimals--
            lastChar--
        }
    }

    fun alBorrar(resultTemp: TextView, resultTemp2: TextView) {
        if (cadena_print.isNotEmpty()) {
            if (lastChar.equals(",")) {
                cadena_print.deleteCharAt(lastChar)
                esDecimal = false
                countDecimals = 0
                lastChar--
                resultTemp.setText(cadena_print)
                mostrarResultTemporal2(resultTemp, resultTemp2, printRes2String)
            } else {
                cadena_print.deleteCharAt(lastChar)
                //12.98
                lastChar--
                countDecimals--
                resultTemp.setText(cadena_print)
                mostrarResultTemporal2(resultTemp, resultTemp2, printRes2String)
            }
        } else {
            resultTemp.setText(getString(R.string.num0))
            mostrarResultTemporal2(resultTemp, resultTemp2, printRes2String)
        }
    }

    fun btnMaterialInput(contBtn : Int, ArrayMaterials : Array<Button>, nomMaterials: Array<String>) {
        val vistaBtn = LayoutInflater.from(this).inflate(R.layout.input_material, null)
        val btnBuildMaterial = AlertDialog.Builder(this)
            .setView(vistaBtn)
            .setTitle(getString(R.string.cotitz_material)+" "+nomMaterials[contBtn])
        val showButtonMaterial = btnBuildMaterial.show()

        vistaBtn.findViewById<Button>(R.id.btnAceptar).setOnClickListener {
            var inputMaterialtext = vistaBtn.findViewById<TextView>(R.id.Preu).text.toString()
            inputMaterialtext = inputMaterialtext.replace(",", ".")
            comprovacioInputMaterial(inputMaterialtext, contBtn, ArrayMaterials, cotitzacioMaterial)
            showButtonMaterial.dismiss()
        }
    }


    fun comprovacioInputMaterial(inputMaterialtext: String, countMaterial : Int, ArrayMaterials : Array<Button>, cotitzacioMaterial : DoubleArray) {
        var sortir: Boolean = false
        if ((inputMaterialtext[0] == '0' && (inputMaterialtext[1]!=',' && inputMaterialtext[1]!='.')) || !inputMaterialtext[0].isDigit()) {
            sortir = true
            materialSeleccionat = false
            Toast.makeText(this, getString(R.string.valorsNumerics), Toast.LENGTH_LONG).show()
        }
        try {
            inputMaterialDouble = inputMaterialtext.toDouble()
        } catch (e: Exception) {
            materialSeleccionat = false
            sortir = true
            Toast.makeText(this,  getString(R.string.valorsNumerics), Toast.LENGTH_LONG).show()
        }
        if (!sortir) {
            if (inputMaterialDouble <= 0) {
                materialSeleccionat = false

            } else {
                materialSeleccionat = true
                ArrayMaterials[countMaterial].setBackgroundColor(getColor(R.color.light_brown))
                cotitzacioMaterial[countMaterial] = inputMaterialDouble

            }
        }
    }

    fun mostrarResultTemporal2(resultTemp: TextView, resultTemp2: TextView, printRes2String: String){
        try{
            var resultTempString : String = resultTemp.text.toString().replace(",", ".")
            var resultTextDouble : Double = resultTempString.toDouble()
            var printResTemporal2 = cotitzacioMaterial[contBtn]*resultTextDouble
            var printRes2String  =  printResTemporal2.toString()
            resultTemp2.setText(printRes2String)
        }
        catch (e: Exception){
            resultTemp2.text=" "
            if (!resultTemp.text.equals("")) {
                Toast.makeText(this, getString(R.string.wrongConversio), Toast.LENGTH_LONG).show()
            }
        }



    }
}

