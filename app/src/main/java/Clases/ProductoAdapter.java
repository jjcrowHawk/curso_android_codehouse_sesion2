package Clases;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.TextView;

import com.example.jjcrow.cursoandroidespolsesin1.R;

import java.util.ArrayList;

public class ProductoAdapter extends BaseAdapter {

    private Context context;
    private ArrayList<Producto> items;

    public ProductoAdapter(Context context, ArrayList<Producto> items){
        this.context= context;
        this.items= items;
    }

    @Override
    public int getCount() {
        return items.size();
    }

    @Override
    public Object getItem(int i) {
        return items.get(i);
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup parent) {
        final int indice= i;
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View contentView= inflater.inflate(R.layout.list_layout,parent,false);
        TextView nombre= contentView.findViewById(R.id.tv_producto);
        TextView precio= contentView.findViewById(R.id.tv_precio);
        TextView cantidad= contentView.findViewById(R.id.tv_cantidad);
        Button btn_eliminar= contentView.findViewById(R.id.btn_eliminar);

        nombre.setText(items.get(i).getNombre());
        precio.setText("$ "+items.get(i).getPrecio());
        cantidad.setText(""+items.get(i).getCantidad());

        btn_eliminar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                items.remove(indice);
                ProductoAdapter.this.notifyDataSetChanged();
            }
        });


        return contentView;
    }
}
