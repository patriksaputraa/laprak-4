package com.javafx;

public class DaftarMahasiswa {
    Mahasiswa[] data;
    int cacah,size;

    DaftarMahasiswa(int tampung){
        this.size = tampung;
        this.data = new Mahasiswa[tampung];
        this.cacah = 0;
    }

    public void growSize(){
        Mahasiswa temp[] = null;
        if(cacah==data.length){
            temp = new Mahasiswa[data.length+1];
            for(int i=0;i<data.length;i++){
                temp[i] = data[i];
            }
        }
        size++;
        data=temp;
    }

    public void decreaseSize(){
        Mahasiswa temp[] = null;
        if(cacah==data.length){
            temp = new Mahasiswa[data.length-1];
            for(int i=0;i<data.length;i++){
                temp[i] = data[i];
            }
        }
        size--;
        data=temp;
    }

    void tambah(String nim, String nama, String kota){
        Mahasiswa add = new Mahasiswa(nim,nama,kota);
        add.setNim(nim);
        add.setNama(nama);
        add.setKota(kota);
        this.data[cacah] = add;
        cacah++;
        growSize();
    }

    public String getAll(){
        String semua = "";
        for (int i = 0; i < this.cacah; i++) {
            semua += (i+1) + ". " + this.data[i].getMahasiswa() + "\n";
        }
        return semua;
    }

    public void bubbleNIM(String sort){
        int p,b;
        Mahasiswa temp;
        if(sort.equals("Ascending")){
            for (p = 1; p < this.cacah; p++) {
                for (b = 0; b < (cacah-p); b++) {
                    if(this.data[b].getNim().compareTo(this.data[b+1].getNim())>0){
                        temp = this.data[b];
                        this.data[b] = this.data[b+1];
                        this.data[b+1] = temp;
                    }
                }
            }
        }else{
            for (p = 1; p < this.cacah; p++) {
                for (b = 0; b < (cacah-p); b++) {
                    if(this.data[b].getNim().compareTo(this.data[b+1].getNim())<0){
                        temp = this.data[b];
                        this.data[b] = this.data[b+1];
                        this.data[b+1] = temp;
                    }
                }
            }
        }
    }

    public void bubbleNama(String sort){
        int p,b;
        Mahasiswa temp;
        if(sort.equals("Ascending")){
            for (p = 1; p < this.cacah; p++) {
                for (b = 0; b < (cacah-p); b++) {
                    if(this.data[b].getNama().compareTo(this.data[b+1].getNama())>0){
                        temp = this.data[b];
                        this.data[b] = this.data[b+1];
                        this.data[b+1] = temp;
                    }
                }
            }
        }else{
            for (p = 1; p < this.cacah; p++) {
                for (b = 0; b < (cacah-p); b++) {
                    if(this.data[b].getNama().compareTo(this.data[b+1].getNama())<0){
                        temp = this.data[b];
                        this.data[b] = this.data[b+1];
                        this.data[b+1] = temp;
                    }
                }
            }
        }
    }

    public void bubbleKota(String sort){
        int p,b;
        Mahasiswa temp;
        if(sort.equals("Ascending")){
            for (p = 1; p < this.cacah; p++) {
                for (b = 0; b < (cacah-p); b++) {
                    if(this.data[b].getKota().compareTo(this.data[b+1].getKota())>0){
                        temp = this.data[b];
                        this.data[b] = this.data[b+1];
                        this.data[b+1] = temp;
                    }
                }
            }
        }else{
            for (p = 1; p < this.cacah; p++) {
                for (b = 0; b < (cacah-p); b++) {
                    if(this.data[b].getKota().compareTo(this.data[b+1].getKota())<0){
                        temp = this.data[b];
                        this.data[b] = this.data[b+1];
                        this.data[b+1] = temp;
                    }
                }
            }
        }
    }

    public void deleteData(){
        cacah--;
        Mahasiswa temp[] = null;
        temp = new Mahasiswa[data.length - 1];
        for (int i = 0; i < data.length-1; i++) {
            temp[i] = this.data[i];
        }
        this.size--;
        this.data=temp;
        //decreaseSize();
    }

    public boolean getCekNim(){
        boolean cek = false;
        if(this.data[cacah-1].cekNim()){
            cek = true;
        }
        return cek;
    }
    
    public boolean getCekString(){
        boolean cek = false;
        if(this.data[cacah-1].cekString()){
            cek = true;
        }
        return cek;
    }
}
