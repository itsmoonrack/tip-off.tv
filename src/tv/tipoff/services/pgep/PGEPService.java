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
	 * Contenu d'une �mission sp�cifique.
	 * 
	 * @param id
	 *            ID de l'�mission.
	 */
	public Program getProgram(String id);

	/**
	 * Liste des �missions.
	 */
	public List<Program> getPrograms();

	/**
	 * Contenu d'une cha�ne sp�cifique.
	 * 
	 * @param id
	 *            ID de la cha�ne.
	 */
	public Channel getChannel(String id);

	/**
	 * Liste des cha�nes.
	 */
	public List<Channel> getChannels();

	/**
	 * Liste des difusions des 7 jours � venir, tri�es par ordre ascendant
	 * d'heure de diffusion. La requ�te retourne les diffusions d�j� entam�es
	 * mais non termin�es lors de l'appel.
	 */
	public List<Broadcast> getBroadcasts();
	
	/**
	 * Liste des difusions des 7 jours � venir, tri�es par ordre ascendant
	 * d'heure de diffusion. La requ�te retourne les diffusions d�j� entam�es
	 * mais non termin�es lors de l'appel.
	 * 
	 * @param to
	 *   Datetime de fin de l'intervalle de temps sur lequel filtrer.
	 */
	public List<Broadcast> getBroadcasts(Date to);

	/**
	 * Contenu d'une diffusion sp�cifique.
	 * 
	 * @param id
	 *            ID de la diffusion.
	 */
	public Broadcast getBroadcast(String id);

	/**
	 * Liste des difusions des 3 heures � venir, tri�es par ordre ascendant
	 * d'heure de diffusion. La requ�te retourne les diffusions d�j� entam�es
	 * mais non termin�es lors de l'appel.
	 */
	public List<Schedule> getSchedule();
	
	/**
	 * Nombre de r�sultats retourn�s par requ�te. La limite autoris�e est de
	 * 1000 r�sultats au maximum.
	 */
	public void setLimit(int limit);
}
