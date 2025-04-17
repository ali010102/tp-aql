package tp2.exo2;

public class Utilisateur {
    private String prenom;
    private String nom;
    private String email;

    // Constructeur
    public Utilisateur(String prenom, String nom, String email) {
        this.prenom = prenom;
        this.nom = nom;
        this.email = email;
    }

    // Getters
    public String getPrenom() {
        return prenom;
    }

    public String getNom() {
        return nom;
    }

    public String getEmail() {
        return email;
    }

    // Setters (optionnels, à activer si besoin)
    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    // Redéfinition toString (utile en debug/logs)
    @Override
    public String toString() {
        return "Utilisateur{" +
                "prenom='" + prenom + '\'' +
                ", nom='" + nom + '\'' +
                ", email='" + email + '\'' +
                '}';
    }

    // Optionnel : equals() et hashCode() si tu compares des utilisateurs dans tes tests
}

