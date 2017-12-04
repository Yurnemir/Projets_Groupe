package fr.adaming.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fr.adaming.dao.IBienLocationDao;
import fr.adaming.enums.TypeRecherche;
import fr.adaming.model.BienLocation;
import fr.adaming.model.Client;
import fr.adaming.model.Criteres;

@Service
@Transactional
public class BienLocationServiceImpl implements IBienLocationService {
	@Autowired
	private IBienLocationDao bienLocationDao;

	public void setBienLocationDao(IBienLocationDao bienLocationDao) {
		this.bienLocationDao = bienLocationDao;
	}

	@Override
	public List<BienLocation> getAllBiensLocation() {
		return bienLocationDao.getAllBiensLocation();
	}

	@Override
	public BienLocation getBienLocationById(int id) {
		return bienLocationDao.getBienLocationById(id);
	}

	@Override
	public BienLocation addBienLocation(BienLocation bienLocation) {
		return bienLocationDao.addBienLocation(bienLocation);
	}

	@Override
	public BienLocation updateBienLocation(BienLocation bienLocation) {
		return bienLocationDao.updateBienLocation(bienLocation);
	}

	@Override
	public void deleteBienLocation(int id) {
		bienLocationDao.getBienLocationById(id);
	}

	@Override
	public List<BienLocation> trierLocationParClient(Client client) {
		boolean location;
		boolean prixAcceptable = false;
		boolean surfaceMaxAcceptable = false;
		boolean surfaceMinAcceptable = false;

		Criteres critere = client.getCriteres();
		System.out.println(client);
		List<BienLocation> listeBienLocation = bienLocationDao.getAllBiensLocation();
		List<BienLocation> listeBienLocationInteret = new ArrayList<>();

		if (critere.getRecherche() != TypeRecherche.LOCATION) {
			location = false;
		} else {
			location = true;
		}

		if (location = false) {
			return listeBienLocationInteret;
		} else {
			for (BienLocation bien : listeBienLocation) {
				prixAcceptable = false;
				surfaceMaxAcceptable = false;
				surfaceMinAcceptable = false;

				if (bien.getTypeBien().equals(critere.getBien())) {
					if (bien.getLoyer() <= critere.getLoyerMax() || critere.getLoyerMax() == 0) {
						if (bien.getSuperficie() <= critere.getSurfaceMax() || critere.getSurfaceMax() == 0) {
							// surfaceMaxAcceptable = true;
							System.out.println("Surface Max OK");
							if (bien.getSuperficie() >= critere.getSurfaceMin() || critere.getSurfaceMin() == 0) {
								surfaceMinAcceptable = true;
								System.out.println("Surface Min OK");
							}
						}
					}
				}

				if (surfaceMinAcceptable == true&&bien.getAdresse().getVille().equals(critere.getVille())) {
					listeBienLocationInteret.add(bien);
				}
			}
			return listeBienLocationInteret;
		}

	}

}
