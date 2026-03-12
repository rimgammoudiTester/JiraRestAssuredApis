package Pojos.jiraExpressions;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class JiraExpression {

   private Object contextVariables;
   private String[] expressions;
}
