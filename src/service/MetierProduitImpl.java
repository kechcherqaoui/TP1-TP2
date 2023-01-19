package service;

import model.Produit;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.List;

public class MetierProduitImpl implements IMetier<Produit>{
    private List<Produit> produits;
    private String fileName = "produits.dat";

    public MetierProduitImpl(List<Produit> produits) {
        this.produits = produits;
    }

    @Override
    public void add(Produit o) {
        this.produits.add(o);
    }

    @Override
    public void saveAll() throws IOException {
        File file = new File(fileName);
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(file));
        oos.writeObject(produits);
        oos.flush();
        oos.close();
    }

    @Override
    public List<Produit> getAll() throws IOException, ClassNotFoundException {
        File file = new File(fileName);
        if (!file.exists())
            return null;

        ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file));
        return (List<Produit>)ois.readObject();
    }

    @Override
    public Produit findById(long id) {
        for (Produit produit : this.produits)
            if (produit.getId() == id)
                return produit;

        return null;
    }

    @Override
    public void delete(long id) {
        produits.remove(findById(id));
    }
}
