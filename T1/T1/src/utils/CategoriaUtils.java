package utils;

import dados.Categoria;

public class CategoriaUtils {
    public Categoria converterStringParaEnum(String entrada) {
        for (Categoria categoria : Categoria.values()) {
            if (categoria.toString().equalsIgnoreCase(entrada)) {
                return categoria;
            }
        }
        return null;
    }
}
