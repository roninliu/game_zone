package com.game.zone.view;

import com.game.zone.R;

import android.app.Activity;
import android.content.Context;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.Gallery;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.Toast;

public class NewListActivity extends Activity {

	private Gallery gallery;

	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.new_list_layout);
		
		gallery = (Gallery) findViewById(R.id.new_list_gallery);
		gallery.setAdapter(new ImageAdapter(this));
		// ����һ��itemClicklistener��Toast������ͼƬ��λ��
		gallery.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> arg0, View v, int position,
					long id) {
				// TODO Auto-generated method stub
				Toast.makeText(
						NewListActivity.this,
						getString(R.string.my_gallery) + position
								+ getString(R.string.my_gallery_text),
						Toast.LENGTH_SHORT).show();
			}

		});
		
		final LayoutInflater inflater = LayoutInflater.from(this);
		final LinearLayout linlayout = (LinearLayout)findViewById(R.id.app_list_content);
		
		
		for(int i=0;i<5;i++){
			RelativeLayout app_item_layout = (RelativeLayout) inflater.inflate(R.layout.app_list_layout, null);
			
			linlayout.addView(app_item_layout);
		}
		
	}

	public class ImageAdapter extends BaseAdapter {
		// ����һ������
		int mGalleryItemBackGround;
		private Context mContext;

		public ImageAdapter(Context c) {
			mContext = c;
			// ʵ�ò����ļ��е�Gallery����
			TypedArray a = obtainStyledAttributes(R.styleable.Gallery);
			// ȡ��gallery���Զ�index id
			mGalleryItemBackGround = a.getResourceId(
					R.styleable.Gallery_android_galleryItemBackground, 0);
			// �ö����styleable�����ܷ���ʵ��
			a.recycle();
		}

		public int getCount() {// �������鳤��
			// TODO Auto-generated method stub
			return myImageIds.length;
		}

		public Object getItem(int position) {
			return position;
		}

		public long getItemId(int position) {// �õ�ͼƬID
			return position;
		}

		public View getView(int position, View converView, ViewGroup parent) {
			
			ImageView i = new ImageView(mContext);
			i.setImageResource(myImageIds[position]);
			i.setScaleType(ImageView.ScaleType.FIT_XY);// ��������ͼƬ�Ŀ��
			//i.setLayoutParams(new Gallery.LayoutParams(FILL_PARENT, 150));// ����layout�Ŀ��
			i.setBackgroundResource(R.drawable.tab_selected);// ���ñ���
			return i;// ���ض���
		}

		private Integer[] myImageIds = { R.drawable.p_1, R.drawable.p_2,
				R.drawable.p_3, R.drawable.p_4, };
	}

}
