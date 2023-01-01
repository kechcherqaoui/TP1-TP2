import java.util.List;

public class MetierProduitImpl implements IMetier<Produit>{
    private List<Produit> produits;

    public MetierProduitImpl(List<Produit> produits) {
        this.produits = produits;
    }

    @Override
    public void add(Produit o) {
        this.produits.add(o);
    }

    @Override
    public List<Produit> getAll() {
        return this.produits;
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
