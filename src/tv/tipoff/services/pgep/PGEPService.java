package tv.tipoff.services.pgep;

import java.util.List;

import tv.tipoff.services.pgep.dto.Broadcast;
import tv.tipoff.services.pgep.dto.Channel;
import tv.tipoff.services.pgep.dto.Program;

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
	 *   ID de l'�mission.
	 */
	public Program getProgram(int id);
	
	/**
	 * Liste des �missions.
	 */
	public List<Program> getPrograms();
	
	/**
	 * Contenu d'une cha�ne sp�cifique.
	 * 
	 * @param id
	 *   ID de la cha�ne.
	 */
	public Channel getChannel(int id);
	
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
	 * Contenu d'une diffusion sp�cifique.
	 * 
	 * @param id
	 *   ID de la diffusion.
	 */
	public Broadcast getBroadcast(int id);
}
