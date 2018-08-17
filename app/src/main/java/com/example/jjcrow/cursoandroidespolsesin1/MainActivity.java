package com.example.jjcrow.cursoandroidespolsesin1;

import android.content.DialogInterface;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

import Clases.Producto;
import Clases.ProductoAdapter;

public class MainActivity extends AppCompatActivity {

    ListView lista;
    FloatingActionButton fab;
    TextView tv_bienvenida;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Toast.makeText(this, "Bienvenido, "+usuario, Toast.LENGTH_SHORT).show();

        tv_bienvenida = (TextView) findViewById(R.id.tv_bienvenida);
        lista= (ListView) findViewById(R.id.lista);
        fab= (FloatingActionButton) findViewById(R.id.botonFlotante);

        String usuario= getIntent().getStringExtra("usuario");

        tv_bienvenida.setText("Bienvenido, " + usuario);

        final ArrayList<Producto> listaProductos= new ArrayList<Producto>();
        listaProductos.add(new Producto("Leche","Carton de Leche",5,1.10));
        listaProductos.add(new Producto("Cebolla","Atado de cebolla",3,0.50));
        listaProductos.add(new Producto("Papa","Papa por libra",10,0.40));
        listaProductos.add(new Producto("Leche","Carton de Leche",5,1.10));
        listaProductos.add(new Producto("Cebolla","Atado de cebolla",3,0.50));
        listaProductos.add(new Producto("Papa","Papa por libra",10,0.40));
        listaProductos.add(new Producto("Leche","Carton de Leche",5,1.10));
        listaProductos.add(new Producto("Cebolla","Atado de cebolla",3,0.50));
        listaProductos.add(new Producto("Papa","Papa por libra",10,0.40));
        ProductoAdapter adapter= new ProductoAdapter(this,listaProductos);
        lista.setAdapter(adapter);

        lista.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(MainActivity.this,"me tocaste",Toast.LENGTH_SHORT);
                Producto prod= listaProductos.get(i);
                final AlertDialog.Builder alert = new AlertDialog.Builder(MainActivity.this);
                alert.setTitle("Descripcion del Producto");
                alert.setMessage(prod.getDescripcion());
                alert.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.dismiss();
                    }
                });
                alert.show();
            }
        });

        fab.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {
                final LayoutInflater inflater = MainActivity.this.getLayoutInflater();
                final View dialogView= inflater.inflate(R.layout.dialog_crear_layout,null);
                Toast.makeText(MainActivity.this, "Ingreso de Datos :v", Toast.LENGTH_SHORT).show();
                AlertDialog.Builder alert = new AlertDialog.Builder(MainActivity.this);
                alert.setTitle("Ingresar una nueva tarea");
                alert.setView(dialogView);
                alert.setPositiveButton("Aceptar",new DialogInterface.OnClickListener(){
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        EditText et_nombre= dialogView.findViewById(R.id.et_nombre);
                        EditText et_descripcion= dialogView.findViewById(R.id.et_descripcion);
                        EditText et_precio= dialogView.findViewById(R.id.et_precio);
                        EditText et_cantidad= dialogView.findViewById(R.id.et_cantidad);
                        String nombre= et_nombre.getText().toString();
                        String descripcion= et_descripcion.getText().toString();
                        double precio = Double.parseDouble(et_precio.getText().toString());
                        int cantidad= Integer.parseInt(et_cantidad.getText().toString());
                        Producto prod = new Producto(nombre,descripcion,cantidad,precio);
                        listaProductos.add(prod);
                        Toast.makeText(MainActivity.this, "Producto Agregado!", Toast.LENGTH_SHORT).show();
                    }

                });
                alert.setNegativeButton("Cancelar", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.dismiss();
                    }
                });
                alert.show();
            }
        });

    }
}
