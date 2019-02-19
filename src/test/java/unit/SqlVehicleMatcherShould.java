package unit;

import replaceType.NewVehicleQuery;
import replaceType.SqlVehicleMatcher;
import org.junit.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class SqlVehicleMatcherShould {
    @Test
    public void find_vehicles() throws Exception {
        SqlVehicleMatcher matcher = new SqlVehicleMatcher();
        NewVehicleQuery query = new NewVehicleQuery("", "");
        query.brandDescription = "VW Polo";

        assertThat(matcher.countVehicles(query)).isEqualTo(1);
    }
}
