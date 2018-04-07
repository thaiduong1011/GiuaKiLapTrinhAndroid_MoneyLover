 using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;

namespace ASPWebAPI.Models
{
    public class MoneyLogModel
    {
        public int Id { get; set; } 
        public string Name { get; set; }
        public int Amount { get; set; }
        public bool Type { get; set; }
        public string Date { get; set; }
        public string Note { get; set; }
        public static bool statusIncome = true;
        public static bool statusOutcome = false;

    }
}