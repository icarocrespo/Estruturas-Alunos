package estruturas.arvore;

import java.util.Collection;
import java.util.Map;
import java.util.Set;
import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import java.util.function.Function;
import main.Estudante;

/**
 *
 * @author Ketrin | Jéssica | Marina
 */
public class Nodo implements Map<Integer, String> {
    private Nodo esquerda;
    private Nodo direita;
    private Estudante estudante;

    public Nodo(Nodo esquerda, Nodo direita, Estudante estudante) {
        this.esquerda = esquerda;
        this.direita = direita;
        this.estudante = estudante;
    }
    
    public Nodo(){
    
    }

    public Nodo getEsquerda() {
        return esquerda;
    }

    public void setEsquerda(Nodo esquerda) {
        this.esquerda = esquerda;
    }

    public Nodo getDireita() {
        return direita;
    }

    public void setDireita(Nodo direita) {
        this.direita = direita;
    }

    public Estudante getEstudante() {
        return estudante;
    }

    public void setEstudante(Estudante estudante) {
        this.estudante = estudante;
    }

    @Override
    public int size() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String get(Object key) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String put(Integer key, String value) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String remove(Object key) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void putAll(Map<? extends Integer, ? extends String> m) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void clear() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Set<Integer> keySet() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Collection<String> values() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean isEmpty() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean containsKey(Object key) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean containsValue(Object value) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Set<Entry<Integer, String>> entrySet() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getOrDefault(Object key, String defaultValue) {
        return Map.super.getOrDefault(key, defaultValue); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void forEach(BiConsumer<? super Integer, ? super String> action) {
        Map.super.forEach(action); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void replaceAll(BiFunction<? super Integer, ? super String, ? extends String> function) {
        Map.super.replaceAll(function); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String putIfAbsent(Integer key, String value) {
        return Map.super.putIfAbsent(key, value); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean remove(Object key, Object value) {
        return Map.super.remove(key, value); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean replace(Integer key, String oldValue, String newValue) {
        return Map.super.replace(key, oldValue, newValue); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String replace(Integer key, String value) {
        return Map.super.replace(key, value); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String computeIfAbsent(Integer key, Function<? super Integer, ? extends String> mappingFunction) {
        return Map.super.computeIfAbsent(key, mappingFunction); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String computeIfPresent(Integer key, BiFunction<? super Integer, ? super String, ? extends String> remappingFunction) {
        return Map.super.computeIfPresent(key, remappingFunction); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String compute(Integer key, BiFunction<? super Integer, ? super String, ? extends String> remappingFunction) {
        return Map.super.compute(key, remappingFunction); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String merge(Integer key, String value, BiFunction<? super String, ? super String, ? extends String> remappingFunction) {
        return Map.super.merge(key, value, remappingFunction); //To change body of generated methods, choose Tools | Templates.
    }
    
    
}
