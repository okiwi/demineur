package org.okiwi.codingdojo.demineur;

import org.junit.Ignore;
import org.junit.Test;

import static org.assertj.core.api.Assertions.*;

public class ChampDeMinesTest {

    @Test
    public void un_champ_de_mine_vide_a_une_solution_vide() {
        testCasDonne(0, 0, "", "");
    }

    @Test
    public void un_champ_monominé_de_dimensions_1_1_signale_cette_mine() {
        testCasDonne(1, 1, "*", "*");
    }

    @Test
    public void un_champ_vide_de_dimensions_1_1_signale_0_bombe() {
        testCasDonne(1, 1, ".", "0");
    }

    @Test
    public void un_champ_de_dimensions_2_1_monominé_indique_la_mine_et_signale_sa_proximité() {
        testCasDonne(2, 1, "*.", "*1");
    }

    @Test
    public void un_champ_de_dimensions_3_1_monominé_indique_la_mine_et_signale_sa_proximité_et_son_absence() {
        testCasDonne(3, 1, "*..", "*10");
    }

    @Test
    public void un_champ_de_dimensions_2_1_post_monominé_signale_la_proximité_de_la_mine_et_cette_dernière() {
        testCasDonne(2, 1, ".*", "1*");
    }

    @Test
    public void un_champ_de_dimensions_3_1_biminé_signale_la_proximité_des_mines_et_ces_dernières() {
        testCasDonne(3, 1, "*.*", "*2*");
    }

    @Test
    @Ignore
    public void un_champ_de_dimensions_2_2_biminé_signale_la_proximité_des_mines_quelque_soit_leur_position_et_ces_dernières() {
        testCasDonne(2, 2, "*.*.", "*2*2");
    }

    private void testCasDonne(int largeur, int hauteur, String champBrut, String champBalisé) {
        final ChampDeMines champDeMines = new ChampDeMines(largeur, hauteur, champBrut);

        final String signalement = champDeMines.signaleLesMines();

        assertThat(signalement).isEqualTo(champBalisé);
    }



}
