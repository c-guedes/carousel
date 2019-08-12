package com.example.customrecycler


import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.Adapter
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions
import de.hdodenhof.circleimageview.CircleImageView
import kotlinx.android.synthetic.main.recarche_picker.view.*


class MainHistorico(
    private val context: Context,
    val clickListener:(positionNow: Int )-> Unit

) : Adapter<MainHistorico.ViewHolder>() {
    private val list: ArrayList<String> = arrayListOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        list.addAll(listOf("claro","vivo","tim","oi","nextel"))
        val view = LayoutInflater.from(context).inflate(R.layout.recarche_picker, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return Integer.MAX_VALUE
    }



    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val positionNow = position % list.size

        holder.let {
            Glide.with(context)
                .load(R.drawable.vivo)
                .placeholder(R.drawable.placeholder_logo)
                .transition(DrawableTransitionOptions.withCrossFade())
                .into(it.brandImage)
            it.textView.text = list[positionNow].capitalize()

            it.itemView.setOnClickListener{clickListener(positionNow)}
        }




//        val parcela = payments.list[position].parcels
//        val brandName= payments.list[position].brand
//        val data= payments.list[position].payment_date
//        val operacao= payments.list[position].product_name
//        val status= getStatus(payments.list[position].status)
//        val valorBruto= payments.list[position].value.toString()
//        val valorLiquido= (payments.list[position].value -
//                payments.list[position].taxs.tax).toString()
//
//        holder.let{
//            it.brandImage.setImageResource(getImage(brandName))
//            it.data.text = TransformData.dataHist(data)
//            it.operacao.text = concatenateStrings(operacao,parcela)
//            it.valorBruto.text = Format.transformMoney(valorBruto)
//            it.valorLiquido.text = Format.transformMoney(valorLiquido)
//            it.status.text = status
//        }
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        // init vals
        val brandImage = itemView.brandImage
        val textView = itemView.textView


            //        val data: NossaFonte = itemView.data
//        val operacao: NossaFonte = itemView.operacao
//        val valorBruto: NossaFonte = itemView.valorBruto
//        val valorLiquido: NossaFonte = itemView.valorLiquido
//        val status: NossaFonte = itemView.status

    }

//    private fun getImage(brandName: String): Int {
//        return when (brandName) {
//            "VISA" -> R.drawable.ic_visa
//            "ELO CREDITO" -> R.drawable.ic_elo
//            "MAESTRO" -> R.drawable.ic_maestro
//            "DISCOVER" -> R.drawable.ic_discover
//            "MASTER" -> R.drawable.ic_master
//            else -> R.drawable.ic_visa
//        }
//    }
//
//    private fun concatenateStrings(campo: String, numParcel: Int): String{
//        return when (campo){
//            "Parcelamento sem Juros" -> "Parcelamento S/ Juros (${numParcel}x)"
//            "Parcelamento com Juros" -> "Parcelamento C/ Juros (${numParcel}x)"
//            else -> campo
//        }
//
//    }
//
//    private fun getStatus(estado: Int): String{
//        return when(estado){
//            0 -> "Pendente | "
//            1 -> "Confirmada | "
//            2 -> "Desfeita | "
//            3 -> "Negada | "
//            else -> "Cancelada | "
//        }
//    }
}