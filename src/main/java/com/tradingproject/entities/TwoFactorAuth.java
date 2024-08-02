package com.tradingproject.entities;

import com.tradingproject.domain.VerificationType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class TwoFactorAuth {

    private boolean isEnabled = false;
    private VerificationType sendTo;
}
