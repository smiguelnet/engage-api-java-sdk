package br.com.setia.engage.sdk.engagesdk.enumerator;

public enum RewardCompositionType {
    //region FIXED CONDITION ===================================================
    /**
     * Not available to be requested - Internal use
     */
    NONE,

    /**
     * Check a single child attribute
     */
    CHECK_SINGLE_ATTRIBUTE,

    /**
     * Check all attributes
     */
    CHECK_ALL_ATTRIBUTES,

    /**
     * Happens all the times - No limit restriction
     */
    ALWAYS,

    /**
     * Happens once and once only
     */
    ONLY_ONCE,
    //endregion

    //region TIMED CONDITION ===================================================

    /**
     * If happened now cannot happen again for XXX minutes
     */
    TIME_FIXED,

    /**
     * It can only happen once every day or week  or month, depending on the setting
     */
    TIME_ONCE_PER_RANGE,
    //endregion

    //region RANDOM CONDITION ===================================================

    /**
     * According to random variable. select variable and outer range e.g. 1 and 10 = 10%; 2 and 10 = 5% or 0.5 and 10 = 5%
     */
    RANDOM_FIXED_VARIABLE,

    /**
     * According to random variable applied to time. select two variables timeA and timeB and happens at random within that range = random variable between the two vars = it cannot happen again for XX minutes. Like number 3 but with XXX minutes being a random var between two ranges
     */
    RANDOM_TIMED_VARIABLE,
    //endregion
}
