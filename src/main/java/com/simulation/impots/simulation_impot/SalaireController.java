package com.simulation.impots.simulation_impot;

import java.util.concurrent.atomic.AtomicLong;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
@RestController
public class SalaireController {
    double calculTrimf(double salaireBrut){
        double salaireAnnuel = salaireBrut*12;
        double trimf;
        if(salaireAnnuel < 600000){
            trimf = 0;
        }
        else if(salaireAnnuel < 1000000){
            trinmf = 3600;
        }
        else if(salaireAnnuel < 2000000){
            trimf = 4800;
        }
        else if(salaireAnnuel < 7000000){
            trimf = 12000;
        }
        else if(salaireAnnuel < 12000000){
            trimf = 18000;
        }
        else if(salaireAnnuel > 12000000){
            trimf = 36000;
        }
		
   }
private double calculImpotPart(double part, double temp){
    double impotAnnuel = temp;
    if(part == 1.5){
        if((temp*0.1)<100000){
            impotAnnuel = temp -100000;
        }
        else if(temp*0.1<300000){
            impotAnnuel = temp*0.9;
        }
        else impotAnnuel = temp -300000;
    }
    else if(part == 2){
        if((temp*0.15)<200000){
            impotAnnuel = temp -200000;
        }
        else if(temp*0.15<650000){
            impotAnnuel = temp*0.85;
        }
        else impotAnnuel = temp - 650000;
    }
    else if(part == 2.5){
        if((temp*0.2)<300000){
            impotAnnuel = temp - 300000;
        }
        else if(temp*0.2<1100000){
            impotAnnuel = temp*0.8;
        }
        else impotAnnuel = temp - 1100000;
    }
    else if(part == 3){
        if((temp*0.25)<400000){
            impotAnnuel = temp - 400000;
        }
        else if(temp*0.25<1650000){
            impotAnnuel = temp*0.75;
        }
        else impotAnnuel = temp - 1650000;
    }
    else if(part == 3.5){
        if((temp*0.3)<500000){
            impotAnnuel = temp - 500000;
        }
        else if(temp*0.3<2030000){
            impotAnnuel = temp*0.7;
        }
        else impotAnnuel = temp - 2030000;
    }
    else if(part == 4){
        if((temp*0.35)<600000){
            impotAnnuel = temp - 600000;
        }
        else if(temp*0.35<2490000){
            impotAnnuel = temp*0.65;
        }
        else impotAnnuel = temp - 2490000;
    }
    else if(part == 4.5){
        if((temp*0.4)<700000){
            impotAnnuel = temp - 700000;
        }
        else if(temp*0.4<2755000){
            impotAnnuel = temp*0.6;
        }
        else impotAnnuel = temp - 2755000;
    }
    else if(part == 5){
        if((temp*0.45)<800000){
            impotAnnuel = temp - 800000;
        }
        else if(temp*0.45<3180000){
            impotAnnuel = temp*0.55;
        }
        else impotAnnuel = temp - 3180000;
    }
    return impotAnnuel;
}
@RequestMapping("/impots/{salaireBrut}")
        private double calculImpot(@RequestParam(value="salaireBrut", defaultValue="0") double salaireBrut, @RequestParam(value="part", defaultValue = "1") double part){
            Salaire salaire = new Salaire();
            double salaireAnnuel = salaireBrut*12;
            double chargeSalaire = salaireAnnuel*0.3;
            // calcu du net imposable qui correspond a la partie du salaire concernee par l'impot
            double netImposable;
            double impotAnnuel;
            double temp;
            if(chargeSalaire<=900000){
                netImposable = salaireAnnuel - chargeSalaire;
            }
            else netImposable = salaireAnnuel - 900000;
            salaire.setSalaireBrut(salaireBrut);
    // determination de la valeur de l'impot mensuele sur le revenu en se basant sur la tranche de salaire
            if(netImposable<=630000){
                temp = 0;
            }
            else if(netImposable<=1500000){
                temp = ((netImposable-630000)*0.2);
            }
            else if (netImposable<=4000000){
                temp = (261000+((netImposable-1500000)*0.3));
            }
            else if (netImposable<=8000000){
                temp = (1136000+((netImposable - 4000000)*0.35));
            }
            else if(netImposable<=13500000){
                temp = (2536000+((netImposable-8000000)*0.37));
            }
            else {
                temp = (4571000+((netImposable-13500000)*0.4));
            }
            impotAnnuel = calculImpotPart(part,temp);
            salaire.setImpotSurRevenu(impotAnnuel/12);
            //il faut definir le trimf

            // normalement la methode doit retourner un objet salaire avec le brut et les differentes retenues sur salaire.
            return impotAnnuel/12;
        }

}
