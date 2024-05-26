//package com.httt.viettravel.Adapter;//package com.httt.viettravel.Adapter;
//
//import android.content.Context;
//import android.content.Intent;
//import android.view.LayoutInflater;
//import android.view.View;
//import android.view.ViewGroup;
//import android.widget.ImageView;
//import android.widget.TextView;
//
//import androidx.annotation.NonNull;
//import androidx.cardview.widget.CardView;
//import androidx.recyclerview.widget.RecyclerView;
//
//import com.httt.viettravel.Model.CommentTour;
//import com.httt.viettravel.Model.Tour;
//import com.httt.viettravel.R;
//
//import java.util.List;
//
//public class CommentTourApdapter extends RecyclerView.Adapter<CommentTourViewHolder> {
//    private Context context;
//    private List<Tour> dataList;
//
////    public void setSearchList(List<CommentTour> dataSearchList){
////        this.dataList = dataSearchList;
////        notifyDataSetChanged();
////    }
//
//    public CommentTourApdapter(Context context,List<Tour> dataList){
//        this.context = context;
//        this.dataList= dataList;
//    }
//
//
//    @NonNull
//    @Override
//    public CommentTourViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
//        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_comment_tour, parent, false);
//        return new CommentTourViewHolder(view);
//    }
//
//    @Override
//    public void onBindViewHolder(@NonNull CommentTourViewHolder holder, int position) {
//        holder.pic.setImageResource(dataList.get(position).getPic());
////        holder.content.setText(dataList.get(position).getContent());
//        holder.location.setText(dataList.get(position).getLocation());
//        holder.day.setText(dataList.get(position).getDay());
////        holder.routine.setText(dataList.get(position).getRoutine());
////        holder.time.setText(dataList.get(position).getTime());
//        holder.price.setText(dataList.get(position).getPrice());
////        holder.vehicle.setText(dataList.get(position).getTime());
////        holder.place.setText(dataList.get(position).getPlace());
//
//        holder.card.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent = new Intent(context, CommentTour.class);
//
//                intent.putExtra("Image", dataList.get(holder.getAdapterPosition()).getPic());
////                intent.putExtra("Content", dataList.get(holder.getAdapterPosition()).getContent());
//                intent.putExtra("Location", dataList.get(holder.getAdapterPosition()).getLocation());
////                intent.putExtra("Routine", dataList.get(holder.getAdapterPosition()).getRoutine());
////                intent.putExtra("Time", dataList.get(holder.getAdapterPosition()).getTime());
//                intent.putExtra("Day", dataList.get(holder.getAdapterPosition()).getDay());
//                intent.putExtra("Price", dataList.get(holder.getAdapterPosition()).getPrice());
////                intent.putExtra("Vehicle", dataList.get(holder.getAdapterPosition()).getVehicle());
////                intent.putExtra("Place", dataList.get(holder.getAdapterPosition()).getPlace());
//
//                context.startActivity(intent);
//            }
//        });
//
//    }
//
//    @Override
//    public int getItemCount() {
//        return dataList.size();
//    }
//}
//
//
//
//
//    class CommentTourViewHolder extends RecyclerView.ViewHolder{
//
//        ImageView pic;
//        TextView content,location, routine,time,price,vehicle,place, day;
//        CardView card;
//
//        public CommentTourViewHolder(@NonNull View itemView) {
//            super(itemView);
//            content = itemView.findViewById(R.id.content);
//            routine = itemView.findViewById(R.id.routine);
//            location = itemView.findViewById(R.id.location);
//            time = itemView.findViewById(R.id.time);
//            price = itemView.findViewById(R.id.price);
//            vehicle = itemView.findViewById(R.id.vehivle);
//            place = itemView.findViewById(R.id.place);
//            day = itemView.findViewById(R.id.day);
//            card = itemView.findViewById(R.id.card);
//        }
//    }
//
//
//
//
