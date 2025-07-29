package rosa.ribeiro.jonas.dto;

public class EmailMessageTemplate {

    public static String messageNotasTemplate(NotasDto notasDto){

        return  "Prezado(a) " + notasDto.getNomeEmpresa() + ",\n\n" +
                "Conforme determina a legislação fiscal vigente, reforçamos a obrigatoriedade do envio dos comprovantes de recolhimento das retenções tributárias federais relacionadas\nà prestação de serviços." +
                "\nSeguem os detalhes da nota fiscal referente ao seu serviço:\n" +
                notasDto.emailBody() +
                "\n\n**Documentos Obrigatórios:**\n" +
                "Comprovante de pagamento do DARF referente a: IRRF, PIS, COFINS e CSLL retidos\n" +
                "GPS referente à retenção de INSS (quando aplicável)\n" +
                "Relatório detalhado das retenções por nota fiscal\n" +
                "\n" +
                "**Prazo para Envio:** Até o último dia útil do mês subsequente.\n" +
                "\n" +
                "---\n" +
                "\n" +
                "**Base Legal:**\n" +
                "Lei nº 9.430/1996, art. 64 – Estabelece a retenção na fonte de IR, CSLL, PIS e COFINS.\n" +
                "Instrução Normativa RFB nº 1.234/2012, art. 7º – Determina a responsabilidade do contratante em fornecer os comprovantes até o último dia útil do mês subsequente à retenção.\n" +
                "Decreto nº 3.000/1999 (RIR/99), art. 927 – Reforça a obrigatoriedade do fornecimento do comprovante de retenção do IR.\n" +
                "\n" +
                "**Penalidades pelo Não Cumprimento:**\n" +
                "Multas previstas no art. 44 da Lei nº 9.430/1996\n" +
                "Responsabilidade solidária, conforme art. 124 do CTN\n" +
                "Riscos de autuações fiscais\n\n" +
                "---\n" +
                "A ausência desses documentos poderá nos obrigar a realizar a cobrança dos valores integrais destacados nas notas fiscais, de forma a mitigar riscos fiscais à nossa empresa.\n" +
                "Contamos com a habitual colaboração de todos e nos colocamos à disposição para quaisquer esclarecimentos.\n"+
                "\n\nAtenciosamente,\n" +
                "Sua Automação de E-mails";

    }

}
