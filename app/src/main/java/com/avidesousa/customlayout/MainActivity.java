package com.avidesousa.customlayout;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ListView lstCiudades=findViewById(R.id.lstCiudades);
        Ciudades[] miArrayCiudades=new Ciudades[4];
        miArrayCiudades[0]=new Ciudades("Toledo","La ciudad imperial",R.drawable.toledo);
        miArrayCiudades[1]=new Ciudades("Ciudad real","La ciudad imperial",R.drawable.ciudadreal);
        miArrayCiudades[2]=new Ciudades("Cuenca","La ciudad imperial",R.drawable.cuenca);
        miArrayCiudades[3]=new Ciudades("Guadalajara","La ciudad imperial",R.drawable.guadalajara);
        lstCiudades.setAdapter(new MiAdaptadorCiudades(this,R.layout.mifila_ciudad,miArrayCiudades));
    }

    public class MiAdaptadorCiudades extends ArrayAdapter<Ciudades>{
        Ciudades[] misObjetos;
        public MiAdaptadorCiudades(Context context,int resource,Ciudades[] objeto ){
            super(context,resource,objeto);
            misObjetos=objeto;
        }

        public View getView(int position, View converView, ViewGroup parent){
            return crearFila(position,converView,parent);
        }

        @Override
        public View getDropDownView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
            return crearFila(position, convertView, parent);
        }

        public View crearFila(int position, View converView, ViewGroup parent){

            //1. inflar el xml con nuestra vista personaizada
            LayoutInflater miInflador=getLayoutInflater();
            View miFila=miInflador.inflate(R.layout.mifila_ciudad,parent,false);

            //2.Encontramos referencis a los objetos a cada uba de las filas infaldas
            TextView txtNombre=miFila.findViewById((R.id.nombreCiudad));
            TextView txtdescripcion=miFila.findViewById((R.id.descripcionCiudad));
            ImageView imgCiudad=miFila.findViewById((R.id.imgCiudad));

            //3.Rellena los datos
            txtNombre.setText((misObjetos[position].nombre));
            txtdescripcion.setText(misObjetos[position].descripcion);
            imgCiudad.setImageResource(misObjetos[position].imagen);


            return miFila;
        }
    }
}