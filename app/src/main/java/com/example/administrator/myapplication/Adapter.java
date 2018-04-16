package com.example.administrator.myapplication;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

public class Adapter extends BaseAdapter {

    private List<Message> datas;
    private Context context;
    private LayoutInflater inflate;

    public Adapter(Context context) {
        datas = new ArrayList<Message>();
        this.context = context;
        inflate = LayoutInflater.from(context);
    }
    public void add(Message info) {
        datas.add(info);
        notifyDataSetChanged();
    }
    public void addb(List<Message> leis) {
        datas.clear();
        datas.addAll(leis);
        notifyDataSetChanged();
    }
    public void adda(List<Message> leis) {

        datas.addAll(leis);
        notifyDataSetChanged();
    }

    @Override
    public int getCount() {
        return datas.size();
    }

    @Override
    public Object getItem(int i) {
        return datas.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        final ViewHolder holderView;
        if (view == null) {
            view = inflate.inflate(R.layout.layout_list, null);
            holderView = new ViewHolder(view);
            view.setTag(holderView);
        } else {
            holderView = (ViewHolder) view.getTag();
        }
        final Message a = datas.get(i);
        if(a.getMsg_type().equals("1")){
            holderView.messageType.setText("已读");
        }else{
        holderView.messageType.setText("未读");
        }
        holderView.messagePeople.setText(a.getMsg_people());
        holderView.messageTime.setText(a.getMsg_time() );
        return view;
    }
    static class ViewHolder {
        @Bind(R.id.message_type)
        TextView messageType;
        @Bind(R.id.message_people)
        TextView messagePeople;
        @Bind(R.id.message_time)
        TextView messageTime;
        ViewHolder(View view) {
            ButterKnife.bind(this, view);
        }
    }


}
