package br.ufrpe.autodrive.dados;

import br.ufrpe.autodrive.negocio.beans.TestDrive;
import java.util.ArrayList;
import java.util.List;

public class RepositorioTestDrive implements IRepositorioTD {

    private List<TestDrive> testDrives;

    public RepositorioTestDrive() {
        this.testDrives = new ArrayList<>();
    }

    @Override
    public void adicionarTestDrive(TestDrive td) {
        this.testDrives.add(td);
    }

    @Override
    public List<TestDrive> listarTestDrives() {
        return this.testDrives;
    }
}
