package com.devsden.turismov01;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class AdaptadorComida extends RecyclerView.Adapter<AdaptadorComida.ViewHolder> {



    private Context mcontext;
    private ArrayList<Items> mlist;

    public AdaptadorComida(Context context, ArrayList<Items> list) {
        mcontext = context;
        mlist = list;
    }


    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        Context context = parent.getContext();
        LayoutInflater layoutInflater = LayoutInflater.from(mcontext);

        //infla la vista de loscardview items
        View view = layoutInflater.inflate(R.layout.card_view_item, parent, false);
        //retorna el holder de la instancia
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {

        Items comidaItem = mlist.get(position);
        //asigna el item basado en las vistas del modelo
        TextView item_titulo = holder.item_titulo;
        TextView item_desc = holder.item_desc;
        ImageView item_img = holder.item_image;

        item_titulo.setText(comidaItem.getItem_titulo());
        item_desc.setText(comidaItem.getItem_desc());
        item_img.setImageResource(comidaItem.getItem_image());

        holder.cv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                Toast.makeText(mcontext,"la posicion es"+position,Toast.LENGTH_SHORT).show();

                switch (position){
                    case 0:
                        Intent intent = new Intent(mcontext, comidauno.class);
                        mcontext.startActivity(intent);
                        break;
                    case 1:
                        Intent intent1 = new Intent(mcontext, comidados.class);
                        mcontext.startActivity(intent1);
                        break;
                    case 2:
                        Intent intent2 =new Intent(mcontext, comidatres.class);
                        mcontext.startActivity(intent2);
                        break;
                    case 3:
                        Intent intent3 =new Intent(mcontext, comidacuatro.class);
                        mcontext.startActivity(intent3);
                        break;
                    case 4:
                        Intent intent4 =new Intent(mcontext, comidacinco.class);
                        mcontext.startActivity(intent4);
                        break;
                    case 5:
                        Intent intent5 =new Intent(mcontext, comidaseis.class);
                        mcontext.startActivity(intent5);
                        break;
                    case 6:
                        Intent intent6 =new Intent(mcontext, comidasiete.class);
                        mcontext.startActivity(intent6);
                        break;
                }
            }
        });

    }
    @Override
    public int getItemCount() {
        return mlist.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        //el holder debe tener una variable para cada objeto
        ImageView item_image;
        TextView item_titulo, item_desc;
        CardView cv;

        //se crea un constructor que acepte el item completo de la fila
        //esto lo hace en la vista del cardview item para buscar cada subvista
        public ViewHolder(View itemView) {
            super(itemView);

            item_image = itemView.findViewById(R.id.imageView);
            item_titulo = itemView.findViewById(R.id.textview1);
            item_desc = itemView.findViewById(R.id.textview2);

            cv = (CardView)itemView.findViewById(R.id.cv_main);
        }

    }
}
