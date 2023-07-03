package com.example.crudfirebase;

import android.os.Parcel;
import android.os.Parcelable;

public class MahasiswaModel implements Parcelable {

//    int id;
    String key;
    String nama;
    String nim;
    String noHp;

    public MahasiswaModel(String key, String nama, String nim, String noHp) {
        //this.id = id;
        this.key = key;
        this.nama = nama;
        this.nim = nim;
        this.noHp = noHp;
    }

    public MahasiswaModel(String nama, String nim, String noHp) {
        this.nama = nama;
        this.nim = nim;
        this.noHp = noHp;
    }

//
//    public int getId() {
//        return id;
//    }
//
//    public void setId(int id) {
//        this.id = id;
//    }


    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getNim() {
        return nim;
    }

    public void setNim(String nim) {
        this.nim = nim;
    }

    public String getNoHp() {
        return noHp;
    }

    public void setNoHp(String noHp) {
        this.noHp = noHp;
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.key);
        dest.writeString(this.nama);
        dest.writeString(this.nim);
        dest.writeString(this.noHp);
    }

    public void readFromParcel(Parcel source) {
        this.key = source.readString();
        this.nama = source.readString();
        this.nim = source.readString();
        this.noHp = source.readString();
    }

    protected MahasiswaModel(Parcel in) {
        this.key = in.readString();
        this.nama = in.readString();
        this.nim = in.readString();
        this.noHp = in.readString();
    }

    public static final Creator<MahasiswaModel> CREATOR = new Creator<MahasiswaModel>() {
        @Override
        public MahasiswaModel createFromParcel(Parcel source) {
            return new MahasiswaModel(source);
        }

        @Override
        public MahasiswaModel[] newArray(int size) {
            return new MahasiswaModel[size];
        }
    };
}
