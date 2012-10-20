package tv.tipoff.services.pgep;

import java.util.Date;
import java.util.List;

import tv.tipoff.services.pgep.dto.Broadcast;
import tv.tipoff.services.pgep.dto.Channel;
import tv.tipoff.services.pgep.dto.Program;
import tv.tipoff.services.pgep.dto.Schedule;

/**
 * Classe de communication avec l'API Pluzz.
 * 
 * @author Sylvain
 * 
 */
public interface PGEPService {

	/**
	 * Contenu d'une émission spécifique.
	 * 
	 * @param id
	 *            ID de l'émission.
	 */
	public Program getProgram(String id);

	/**
	 * Liste des émissions.
	 */
	public List<Program> getPrograms();

	/**
	 * Contenu d'une chaîne spécifique.
	 * 
	 * @param id
	 *            ID de la chaîne.
	 */
	public Channel getChannel(String id);

	/**
	 * Liste des chaînes.
	 */
	public List<Channel> getChannels();

	/**
	 * Liste des difusions des 7 jours à venir, triées par ordre ascendant
	 * d'heure de diffusion. La requête retourne les diffusions déjà entamées
	 * mais non terminées lors de l'appel.
	 */
	public List<Broadcast> getBroadcasts();
	
	/**
	 * Liste des difusions des 7 jours à venir, triées par ordre ascendant
	 * d'heure de diffusion. La requête retourne les diffusions déjà entamées
	 * mais non terminées lors de l'appel.
	 * 
	 * @param to
	 *   Datetime de fin de l'intervalle de temps sur lequel filtrer.
	 */
	public List<Broadcast> getBroadcasts(Date to);

	/**
	 * Contenu d'une diffusion spécifique.
	 * 
	 * @param id
	 *            ID de la diffusion.
	 */
	public Broadcast getBroadcast(String id);

	/**
	 * Liste des difusions des 3 heures à venir, triées par ordre ascendant
	 * d'heure de diffusion. La requête retourne les diffusions déjà entamées
	 * mais non terminées lors de l'appel.
	 */
	public List<Schedule> getSchedule();
	
	/**
	 * Nombre de résultats retournés par requête. La limite autorisée est de
	 * 1000 résultats au maximum.
	 */
	public void setLimit(int limit);
}
