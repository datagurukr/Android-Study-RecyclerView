package kr.dataguru.recyclerview;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import java.util.ArrayList;

/**
 * Created by dataguru on 2016. 12. 25..
 */
public class Adapter extends RecyclerView.Adapter<Adapter.ViewHolder> {
    private static final String TAG = Adapter.class.getSimpleName();

    private Context context;
    private LayoutInflater layoutInflater;
    private ArrayList<Data> data;

    public Adapter(Context context, ArrayList<Data> data) {
        this.context = context;
        this.layoutInflater = LayoutInflater.from(this.context);
        this.data = data;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View convertView;
        convertView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item, parent, false);
        ViewHolder viewHolder = new ViewHolder(convertView);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder viewHolder, int position) {

        // 데이터 삽입
        viewHolder.id.setText("id : " + data.get(position).id);
        viewHolder.name.setText("name : "+data.get(position).name);

        // 테그 지정 ( 리스트의 위치 값 을 알아내기 위해 사용 )
        viewHolder.btn.setTag(position);

        // 이벤트 핸들러 지정
        viewHolder.btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.v(TAG,"position : "+((Integer) view.getTag()));
                Log.v(TAG,"id : "+data.get((Integer) view.getTag()).id);
                Log.v(TAG,"name : "+data.get((Integer) view.getTag()).name);
            }
        });
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public LinearLayout item;
        public TextView id;
        public TextView name;
        public Button btn;
        public ViewHolder(View convertView) {
            super(convertView);
            item = (LinearLayout) convertView.findViewById(R.id.item);
            id = (TextView) convertView.findViewById(R.id.id);
            name = (TextView) convertView.findViewById(R.id.name);
            btn = (Button) convertView.findViewById(R.id.btn);
        }
    }

    @Override
    public void onViewRecycled(ViewHolder holder) {
        super.onViewRecycled(holder);
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

}
