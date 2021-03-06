package com.example.alfaproject.parsers;

import com.example.alfaproject.DTO.CurrenciesDTO;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

class CurrencyParserTest {

    private static CurrencyParser currencyParser;

    @BeforeAll
    public static void setUp(){
        currencyParser = new CurrencyParser();
    }


    @Test
    void getCurrDataFromJSON() throws JsonProcessingException {
        //given
        String jsonStr = "{\"disclaimer\":\"Usage subject to terms: https://openexchangerates.org/terms\",\"license\":\"https://openexchangerates.org/license\",\"timestamp\":1654192800,\"base\":\"USD\",\"rates\":{\"AED\":3.673,\"AFN\":89.012752,\"ALL\":112.7,\"AMD\":446.111175,\"ANG\":1.8027,\"AOA\":426.46885,\"ARS\":120.474533,\"AUD\":1.376548,\"AWG\":1.8,\"AZN\":1.7,\"BAM\":1.829101,\"BBD\":2,\"BDT\":89.097115,\"BGN\":1.8206,\"BHD\":0.377013,\"BIF\":2027,\"BMD\":1,\"BND\":1.375125,\"BOB\":6.886751,\"BRL\":4.7959,\"BSD\":1,\"BTC\":0.000033103226,\"BTN\":77.557803,\"BWP\":12.007837,\"BYN\":3.377397,\"BZD\":2.016207,\"CAD\":1.257188,\"CDF\":2002.5,\"CHF\":0.958585,\"CLF\":0.02944,\"CLP\":812.35,\"CNH\":6.65782,\"CNY\":6.6603,\"COP\":3784.294682,\"CRC\":682.951856,\"CUC\":1,\"CUP\":25.75,\"CVE\":103.08,\"CZK\":22.9593,\"DJF\":177.55,\"DKK\":6.92191,\"DOP\":55.15,\"DZD\":144.865,\"EGP\":18.659061,\"ERN\":15.000001,\"ETB\":51.6,\"EUR\":0.930505,\"FJD\":2.1368,\"FKP\":0.794818,\"GBP\":0.794818,\"GEL\":2.98,\"GGP\":0.794818,\"GHS\":7.825,\"GIP\":0.794818,\"GMD\":54.1125,\"GNF\":8837.5,\"GTQ\":7.711415,\"GYD\":209.270728,\"HKD\":7.84516,\"HNL\":24.56,\"HRK\":7.0093,\"HTG\":113.027875,\"HUF\":366.94321,\"IDR\":14441.416667,\"ILS\":3.3303,\"IMP\":0.794818,\"INR\":77.392103,\"IQD\":1460,\"IRR\":42300,\"ISK\":127.63,\"JEP\":0.794818,\"JMD\":154.083325,\"JOD\":0.709,\"JPY\":129.8325,\"KES\":116.85,\"KGS\":79.547701,\"KHR\":4061,\"KMF\":458.749854,\"KPW\":900,\"KRW\":1245.3025,\"KWD\":0.306015,\"KYD\":0.833548,\"KZT\":435.356279,\"LAK\":13473.926317,\"LBP\":1516.5,\"LKR\":360.089571,\"LRD\":151.999978,\"LSL\":15.525,\"LYD\":4.775,\"MAD\":9.84,\"MDL\":19.029579,\"MGA\":3995,\"MKD\":57.622616,\"MMK\":1851.951094,\"MNT\":3105.3554,\"MOP\":8.083813,\"MRU\":36.51,\"MUR\":43.600229,\"MVR\":15.44,\"MWK\":816.25,\"MXN\":19.559181,\"MYR\":4.391,\"MZN\":63.849999,\"NAD\":15.56,\"NGN\":415.099715,\"NIO\":35.82,\"NOK\":9.37899,\"NPR\":124.092289,\"NZD\":1.524193,\"OMR\":0.385033,\"PAB\":1,\"PEN\":3.70975,\"PGK\":3.525,\"PHP\":52.813997,\"PKR\":197.598969,\"PLN\":4.255545,\"PYG\":6853.404087,\"QAR\":3.64125,\"RON\":4.5988,\"RSD\":109.275,\"RUB\":63.749998,\"RWF\":1028.5,\"SAR\":3.750704,\"SBD\":8.116969,\"SCR\":13.618791,\"SDG\":455.5,\"SEK\":9.705,\"SGD\":1.370817,\"SHP\":0.794818,\"SLL\":12887.2,\"SOS\":583,\"SRD\":21.1215,\"SSP\":130.26,\"STD\":22994,\"STN\":23.15,\"SVC\":8.752578,\"SYP\":2512.53,\"SZL\":15.525,\"THB\":34.2715,\"TJS\":11.37779,\"TMT\":3.51,\"TND\":3.0365,\"TOP\":2.306693,\"TRY\":16.473505,\"TTD\":6.778922,\"TWD\":29.202499,\"TZS\":2329,\"UAH\":29.531041,\"UGX\":3755.977862,\"USD\":1,\"UYU\":39.974162,\"UZS\":11015,\"VES\":5.0842,\"VND\":23198,\"VUV\":114.629832,\"WST\":2.612952,\"XAF\":610.371424,\"XAG\":0.04491657,\"XAU\":0.00053529,\"XCD\":2.70255,\"XDR\":0.728421,\"XOF\":610.371424,\"XPD\":0.00048782,\"XPF\":111.038811,\"XPT\":0.00097277,\"YER\":250.300047,\"ZAR\":15.463719,\"ZMW\":17.16923,\"ZWL\":322}}";

        //when
        CurrenciesDTO currenciesDTO = currencyParser.getCurrDataFromJSON(jsonStr);

        //then
        assertAll(
                () -> {
                    assertEquals(currenciesDTO.getBase(), "USD");
                    assertEquals(currenciesDTO.getDate(), new Date(1654192800000L));
                    assertEquals(currenciesDTO.getRates().get("RUB"), 63.749998);
                    assertEquals(currenciesDTO.getRates().get("EUR"), 0.930505);
                }
        );

    }
}