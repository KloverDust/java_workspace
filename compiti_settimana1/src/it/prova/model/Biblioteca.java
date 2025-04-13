package it.prova.model;

public class Biblioteca {
    private MaterialeBiblioteca[] listaMaterialiInBiblioteca;

    public Biblioteca(MaterialeBiblioteca[] listaMaterialiInBiblioteca){
        this.listaMaterialiInBiblioteca = listaMaterialiInBiblioteca;
    }

    public Biblioteca(){

    }

    public MaterialeBiblioteca[] getListaMaterialiInBiblioteca() {
        return listaMaterialiInBiblioteca;
    }

    public void setListaMaterialiInBiblioteca(MaterialeBiblioteca[] listaMaterialiInBiblioteca) {
        this.listaMaterialiInBiblioteca = listaMaterialiInBiblioteca;
    }

    public void aggiungiMateriale(MaterialeBiblioteca m) {
        int numeroMaterialiDisponibili = this.listaMaterialiInBiblioteca.length;
        MaterialeBiblioteca[] listaMaterialiNuova = new MaterialeBiblioteca[numeroMaterialiDisponibili +1];

        for (int i = 0; i< this.listaMaterialiInBiblioteca.length; i++){
            listaMaterialiNuova[i] = this.listaMaterialiInBiblioteca[i];
        }

        listaMaterialiNuova[numeroMaterialiDisponibili] = m;
        this.listaMaterialiInBiblioteca = listaMaterialiNuova;
    }

    public MaterialeBiblioteca[] cercaMaterialePerTitolo(String titoloInput){
        int occorenzeStessoTitolo = 0;
        for(MaterialeBiblioteca mb : this.listaMaterialiInBiblioteca){
            //NOTA: Ho bisogno di mb.getTitolo() perché le istanze di MaterialeBiblioteca verranno create in una
            // classe esterna al package e quindi a causa del protected devo usare i metodi get per accedervi
            // if (mb.titolo.equals(titoloInput))
            //  occorenzeStessoTitolo++;

            if (mb.getTitolo().equals(titoloInput))
               occorenzeStessoTitolo++;
        }
        MaterialeBiblioteca[] materialiConStessoTitolo = new MaterialeBiblioteca[occorenzeStessoTitolo];

        int j=0;
        for(MaterialeBiblioteca mb : this.listaMaterialiInBiblioteca){
            if (mb.titolo.equals(titoloInput)) {
                materialiConStessoTitolo[j] = mb;
                j++;
            }

        }
        return materialiConStessoTitolo;
    }

    public MaterialeBiblioteca[] elencaMaterialiDisponibili() {
        int numeroMaterialiDisponibili = 0;
        for(MaterialeBiblioteca mb : this.listaMaterialiInBiblioteca){ // Non ho bisogno di fare this.getListaMateriali() perché listaMaterialiInBiblioteca è una variabile definita in Biblioteca
            if (mb.isDisponibile())
                numeroMaterialiDisponibili++;
        }
        MaterialeBiblioteca[] materialiDisponibili = new MaterialeBiblioteca[numeroMaterialiDisponibili];

        int j=0;
        for(MaterialeBiblioteca mb : this.listaMaterialiInBiblioteca){
            if (mb.isDisponibile()) {
                materialiDisponibili[j] = mb;
                j++;
            }

        }
        return materialiDisponibili;
    }

    public MaterialeBiblioteca[] elencaMaterialiNonDisponibili() {
        int numeroMaterialiNonDisponibili = 0;
        for(MaterialeBiblioteca mb : this.listaMaterialiInBiblioteca){ // Non ho bisogno di fare this.getListaMateriali() perché listaMaterialiInBiblioteca è una variabile definita in Biblioteca
            if (!mb.isDisponibile())
                numeroMaterialiNonDisponibili++;
        }
        MaterialeBiblioteca[] materialiNonDisponibili = new MaterialeBiblioteca[numeroMaterialiNonDisponibili];

        int j=0;
        for(MaterialeBiblioteca mb : this.listaMaterialiInBiblioteca){
            if (!mb.isDisponibile()) {
                materialiNonDisponibili[j] = mb;
                j++;
            }

        }
        return materialiNonDisponibili;
    }
}
