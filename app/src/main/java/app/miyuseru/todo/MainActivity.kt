package app.miyuseru.todo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import androidx.core.app.ComponentActivity.ExtraData
import androidx.core.content.ContextCompat.getSystemService
import android.icu.lang.UCharacter.GraphemeClusterBreak.T
import sun.jvm.hotspot.utilities.IntArray



class MainActivity : AppCompatActivity() {

    lateinit var adapter : ArrayAdapter<String>

    var toastMessage: String? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        adapter = ArrayAdapter(this,android.R.layout.simple_expandable_list_item_1)
        listView.adapter = adapter
    }

    fun add(view: View?){
        val text : String = editText.text.toString()
        Toast.makeText(this,"追加しました",Toast.LENGTH_SHORT).show()

        adapter.add(text)

        listView.onItemClickListener = AdapterView.OnItemClickListener{parent: AdapterView<*>?,view:View?,position:Int, id:Long ->
            val adapter : ArrayAdapter<String> = listView.adapter as ArrayAdapter<String>
            val item = adapter.getItem(position)
            adapter.remove(item)
            adapter.add(item)

        }

        listView.onItemLongClickListener = AdapterView.OnItemLongClickListener { parent: AdapterView<*>, view: View, position: Int, id: Long ->

            val adapter = listView.adapter as ArrayAdapter<String>
            val item =adapter.getItem(position)
            adapter.remove(item)

            false


        }


    }


}
